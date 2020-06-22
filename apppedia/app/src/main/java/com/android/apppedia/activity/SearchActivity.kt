package com.android.apppedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.apppedia.Adapter.RecordListAdapter
import com.android.apppedia.R
import com.android.apppedia.api.NetworkCore
import com.android.apppedia.api.ApppediaApi
import com.android.apppedia.data.Record
import com.android.apppedia.repository.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var recordList: ArrayList<Record>

        val autoCompleteList = listOf("Music Player - Audio Player","HD Camera for Android","Web Browser & Explorer","Ringtone Maker - Mp3 Editor & Music Cutter","QR Code Scan & Barcode Scanner","Video Maker Movie Editor","Music Player for Android-Audio","Notes","Music Player - Bass Booster & Free Music","Music Player Pro","EBook Reader & Free ePub Books","Music Player & Audio Player","Photo Gallery - Photo Album Vault & Photo Editor","HD Camera - Video, Panorama, Filters, Photo Editor","Music player - 10 bands equalizer Audio player","Volume booster - Sound Booster & Music Equalizer","Music Player +","Photo Editor Pro - Collage Maker & Photo Gallery","Video Maker - Video Editor & Photo Slideshow Maker","HD Camera Pro- AD Free Edition","Zalo - Video Call","Zing MP3","Laban Key Go Tieng Viet","Zing TV – Xem phim mới HD","Tu Dien Anh Viet Laban","Laban Key - Colorful Themes","Zing MP3 - Android TV","Laban Key - Clay Themes","Laban Key - Rose Themes","Laban Key - Simple Themes","Zamoji - Make Your Personal Sticker","Zing TV - Android TV","Laban SMS: spam blocker","Zalo OA Admin","Zavatar - Tạo sticker, khoe cá tính","Piano Free - Keyboard with Magic Tiles Music Games","Real Guitar Free - Chords, Tabs & Simulator Games","Chromatic Guitar Tuner Free: Ukulele, Bass, Violin","Drum Set Music Games & Drums Kit Simulator","Drum Pads - Beat Maker Go","Cool Goal! — Soccer game","Idle Oil Tycoon: Gas Factory Simulator","Piano - Play & Learn Music","Domino Smash","Real Metronome for Guitar, Drums & Piano for Free","Defuse The Bomb 3D","Balls Rollerz Idle 3D Puzzle","Pregnancy Idle 3D Simulator","Real Ukulele Free - Tabs, Chords and Songs on Uke","Happy Hockey!","Idle Port Tycoon - Sea port empire","Guitar Play - Games & Songs","Cleon - Warrior Fall","Karaoke - Sing Songs!","Jambl: Beat Maker & Dj Music Creator","Music Zen - Relaxing Sounds","Beat Maker - Rhythm Game","Coin Dozer: Sweepstakes","Prize Claw","Taps to Riches","Prize Claw 2","Coin Dozer: Casino","4 Pics 1 Song","Paplinko - Free Pachinko Game","Brick Breaker Hero","Cookie Dozer","Coin Dozer: Haunted Ghosts","Merge Zoo","YouTube","Google Play services","Google Photos","Google Chrome: Fast & Secure","Google","Maps - Navigate & Explore","Google Play Games","Gmail","Google Translate","Google+ for G Suite","Google Duo - High Quality Video Calls","Gboard - the Google Keyboard","Google Drive","Google Play Music","Hangouts","Google Pay (Tez) - a simple and secure payment app","Android System WebView","Messages","Files by Google: Clean up space on your phone","Google Earth","Google Street View","Android Accessibility Suite","Google Text-to-Speech","YouTube Go","Google Opinion Rewards","Google Play Books - Ebooks, Audiobooks, and Comics","Google Play Movies & TV","Google News: Top World & Local News Headlines","Google Calendar","Google Docs","YouTube Music - Stream Songs & Music Videos","Snapseed","YouTube Kids","Android Auto - Google Maps, Media & Messaging","Google Keep - Notes and Lists","Google Pay: Pay with your phone and send cash","Google Home","YouTube Studio","Google Sheets","Google Find My Device","Google Indic Keyboard","Google Lens","Google Family Link for parents","Google Camera","Carrier Services","Cloud Print","Google Slides","Google Fit: Health and Activity Tracking","Contacts","Google Go: A lighter, faster way to search","Google PDF Viewer","Chrome Beta","Google Podcasts: Discover free & trending podcasts","Clock","Google Authenticator","Google Assistant - Get things done, hands-free","Google Voice","Wear OS by Google Smartwatch (was Android Wear)","Chrome Remote Desktop","Google Pinyin Input","Google My Business - Connect with your Customers","Phone","Google Play Services for AR","Calculator","Blogger","Cardboard","Google Meet","Digital Wellbeing","Google Classroom","Hangouts Dialer - Call Phones","Navigation for Google Maps Go","Wallpapers","Google Analytics","Google Handwriting Input","PhotoScan by Google Photos","Google Assistant Go","Chrome Dev","Google Japanese Input","YouTube TV - Watch & Record Live TV","Google Tasks: Any Task, Any Goal. Get Things Done","Google My Maps","Google Apps Device Policy","Google Korean Input","Google Maps Go - Directions, Traffic & Transit","Google Ads","Google One","Google Family Link for children & teens","Android TV Remote Control","Google Arts & Culture","Chrome Canary (Unstable)","Google Spotlight Stories","Gmail Go","Google VR Services","Grasshopper: Learn to Code for Free","Google Wifi","Gallery Go by Google Photos","Google I/O 2019","Google Admin","Socratic by Google","Google Play Console","Google Fi","Google Shopping: Discover, compare prices & buy","Measure","Crowdsource","Wear OS Phone","Sound Amplifier","Voice Access","Google Support Services","YouTube for Google TV","Trusted Contacts","Cardboard Design Lab","Android Device Policy","Cloud Console","Google Chat","Science Journal","Daydream","Expeditions","Screenwise Meter","YouTube VR","Intersection Explorer","Accessibility Scanner","Google Pixel Buds","Google BrailleBack","Android Market","Daydream Keyboard","Google Cloud Search","Jamboard","Android Auto for phone screens","Creative Preview","YouTube for Android TV","Google Time Zone Data","Beacon Tools","Personal Safety","Chromecast built-in","VR180","Live Channels","Android TV Launcher","Study Kit","Google Arts & Culture VR","Facebook","Messenger – Text and Video Chat for Free","Facebook Lite","Messenger Lite: Free Calls & Messages","Facebook Pages Manager","Workplace from Facebook","Facebook Gaming: Watch, Play, and Connect","Messenger Kids – The Messaging App for Kids","Facebook Ads Manager","Lasso - short, fun videos","Facebook Local","Workplace Chat","Free Basics by Facebook","Facebook Analytics","Express Wi-Fi by Facebook","Creator Studio","Study from Facebook","Origami Live","Facebook Viewpoints","Portal from Facebook","WhatsApp Messenger","WhatsApp Wallpaper","WhatsApp Business","Clash of Clans","Clash Royale","Brawl Stars","Hay Day","Boom Beach","Rush Wars","Instagram","Boomerang from Instagram","Layout from Instagram: Collage","IGTV","Direct from Instagram","Threads from Instagram","Candy Crush Saga","Farm Heroes Saga","Candy Crush Soda Saga","Pet Rescue Saga","Bubble Witch 2 Saga","Bubble Witch 3 Saga","Candy Crush Jelly Saga","Candy Crush Friends Saga","Blossom Blast Saga","Diamond Digger Saga","Farm Heroes Super Saga","Papa Pear Saga","Pyramid Solitaire Saga","Bubble Witch Saga","AlphaBetty Saga","Shuffle Cats","Scrubby Dubby Saga","Pet Rescue Puzzle Saga","Legend of Solgard","Knighthood","Diamond Diaries Saga","Minion Rush: Despicable Me Official Game","Asphalt 8: Airborne - Fun Real Car Racing Game","Gangstar Vegas: World of Crime","Modern Combat 5: eSports FPS","Dragon Mania Legends","Six-Guns: Gang Showdown","Ice Age Village","GT Racing 2: The Real Car Exp","Blitz Brigade - Online FPS fun","Asphalt 9: Legends - Epic Car Action Racing Game","Asphalt Nitro","Ice Age Adventures","Brothers in Arms® 3","MY LITTLE PONY: Magic Princess","N.O.V.A. Legacy","Sniper Fury: Online 3D FPS & Sniper Shooter Game","Green Farm 3","Littlest Pet Shop","Real Football","Dungeon Hunter 5 – Action RPG","World at Arms","Heroes of Order & Chaos","Asphalt Xtreme: Rally Racing","Wonder Zoo - Animal rescue !","Disney Magic Kingdoms: Build Your Own Magical Park","Gangstar New Orleans OpenWorld","Gods of Rome","Order & Chaos Online 3D MMORPG","Little Big City 2","Rival Knights","Total Conquest","The Oregon Trail: Settler","March of Empires: War of Lords","Order & Chaos Duels","Iron Blade: Medieval Legends RPG","Order & Chaos 2: 3D MMO RPG","City Mania: Town Building Game","Modern Combat 4: Zero Hour","Modern Combat Versus: New Online Multiplayer FPS","Zombie Anarchy: Survival Strategy Game","Siegefall","Asphalt Street Storm Racing","Pastry Paradise","War Planet Online: Real Time Strategy MMO Game","Gangstar Rio: City of Saints","Gameloft Classics: 20 Years","Wild Blood","Disney Princess Majestic Quest: Match 3 & Decorate","Dungeon Hunter Champions: Epic Online Action RPG","Modern Combat 3: Fallen Nation","Disney Getaway Blast","Country Friends","LEGO® Legacy: Heroes Unboxed","Overdrive City – Car Tycoon Game","Paddington™ Run: Endlessly fun adventures","The Love Boat: Puzzle Cruise – Your Match 3 Crush!","Sonic Runners Adventure - Fast Action Platformer","Plants vs Zombies™ 2 Free","FIFA Soccer","Real Racing  3","The Sims FreePlay","SimCity BuildIt","Plants vs. Zombies FREE","Need for Speed™ No Limits","The Simpsons™:  Tapped Out","EA SPORTS UFC®","NBA LIVE Mobile Basketball","Madden NFL Mobile Football","Star Wars™: Galaxy of Heroes","The Sims™ Mobile","The Sims™ FreePlay")

        val autotextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, autoCompleteList)
        autotextView.setAdapter(adapter)

        NetworkCore.getNetworkCore<ApppediaApi>()
                .requestRecordList(
                        App.prefs.TOKEN.toString(),
                        App.prefs.EMAIL.toString()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    recordList = response
                    val adapter = RecordListAdapter(recordList, this@SearchActivity)
                    rv_record.adapter = adapter
                    rv_record.addItemDecoration(
                            DividerItemDecoration(
                                    this,
                                    DividerItemDecoration.VERTICAL
                            )
                    )
                    rv_record.layoutManager = LinearLayoutManager(this@SearchActivity)
                }, { except ->

                })

        iv_search.isSelected = validateStep()

        iv_search.setOnClickListener {
            if(iv_search.isSelected){
                var requestrecordsave = Record(
                        "string",
                        App.prefs.EMAIL.toString(),
                        autoCompleteTextView.text.toString()
                )
                NetworkCore.getNetworkCore<ApppediaApi>()
                        .requestRecordSave(
                                App.prefs.TOKEN.toString(),
                                requestrecordsave
                        )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            val intent = Intent(this, SearchListActivity::class.java)
                            intent.putExtra("Search", autoCompleteTextView.text.toString())
                            startActivity(intent)
                        }, { except ->
                            Log.d("error",except.toString())
                        })
            }
            else {
                Toast.makeText(this@SearchActivity, "검색어를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        autoCompleteTextView.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                statusText(validateStep())
            }
        })

        iv_cancel.setOnClickListener {
            if (App.prefs.BEFORE.toString() == '1'.toString())
            {
                val intent = Intent(this, MainFavoritesActivity::class.java)
                startActivity(intent)
                finish()
            }
            else if (App.prefs.BEFORE.toString() == '2'.toString())
            {
                val intent = Intent(this, MainRelatedActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                val intent = Intent(this, MainScsetActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun statusText(boolean: Boolean) {
        iv_search.isSelected = boolean
    }

    fun validateStep() : Boolean = autoCompleteTextView.text.isNotEmpty()
}