package com.android.apppedia.api

import com.android.apppedia.data.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface ApppediaApi {

    @POST("/user/logup")
    fun requestUserLogUp(@Body body: User): Completable

    @POST("/user/info/{email}")
    fun requestUserInfo(@Header("Authorization") authorization: String?, @Path("email") email:String): Single<User>

    @POST("/user/modify/")
    fun requestUserModify(@Header("Authorization") authorization: String?, @Body body: User): Completable



    @POST("/auth/login")
    fun requestAuthLogIn(@Body body: Auth): Single<Authorization>



    @POST("/contact/list/{user_email}")
    fun requestContactList(@Header("Authorization") authorization: String?, @Path("user_email") user_email:String): Single<ArrayList<Contact_List>>

    @POST("/contact/info/{public_id}")
    fun requestContactInfo(@Header("Authorization") authorization: String?, @Path("public_id") public_id:String): Single<Contact_info>

    @POST("/contact/save")
    fun requestContactSave(@Header("Authorization") authorization: String?, @Body body:Contact_info): Completable



    @POST("/record/list/{user_email}")
    fun requestRecordList(@Header("Authorization") authorization: String?, @Path("user_email") user_email:String): Single<ArrayList<Record>>

    @POST("/record/save")
    fun requestRecordSave(@Header("Authorization") authorization: String?, @Body body: Record): Completable

    @POST("/record/remove/{public_id}")
    fun requestRecordRemove(@Header("Authorization") authorization: String?, @Path("public_id") public_id:String): Single<Record>



    @POST("favorites/list/{user_email}")
    fun requestFavoritesList(@Header("Authorization") authorization: String?, @Path("user_email") user_email:String): Single<ArrayList<Favorites_List>>

    @POST("/favorites/save")
    fun requestFavoritesSave(@Header("Authorization") authorization: String?, @Body body: Favorites_Save): Completable

    @POST("/favorites/remove/{public_id}")
    fun requestFavoritesRemove(@Header("Authorization") authorization: String?, @Path("public_id") public_id:String): Single<Favorites_Save>



    @POST("/application/auto")
    fun requestApplicationAuto(@Header("Authorization") authorization: String?): Single<Application_Auto>

    @POST("/application/srch")
    fun requestApplicationSrch(@Header("Authorization") authorization: String?, @Body body: Application_Srch): Single<ArrayList<Application_Rslt>>

    @POST("/application/comp")
    fun requestApplicationComp(@Header("Authorization") authorization: String?, @Body body: Application_Comp): Single<Application_Rult>

    @POST("/application/info/{public_id}")
    fun requestApplicationInfo(@Header("Authorization") authorization: String?, @Path("public_id") public_id:String): Single<Application_info>

    @POST("/application/plus/{category}")
    fun requestApplicationPlus(@Header("Authorization") authorization: String?, @Path("category") category:String): Single<ArrayList<Application_Plus>>



    @POST("/developer/info/{public_id}")
    fun requestDeveloperInfo(@Header("Authorization") authorization: String?, @Path("public_id") public_id:String): Single<Developer>



    @POST("/function/list/{application_public_id}")
    fun requestFunctionList(@Header("Authorization") authorization: String?, @Path("application_public_id") application_public_id:String): Single<ArrayList<Functionss>>
}