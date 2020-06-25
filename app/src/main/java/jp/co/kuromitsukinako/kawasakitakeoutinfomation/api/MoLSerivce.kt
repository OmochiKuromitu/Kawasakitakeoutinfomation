package jp.co.kuromitsukinako.kawasakitakeoutinfomation.api

import retrofit2.Response
import retrofit2.http.*


interface MoLSerivce {

//    // login
//    @POST("api/auth_social/login")
//    suspend fun socailLogin(@Body body: SocalLoginBody): Response<SocalLoginResponse>
//
//    // Beacon情報取得
//    @GET("/api/current_position/beacon_search")
//    suspend fun searchBeacon(
//        @Query("fromDateTime") fromDateTime:String,
//        @Query("toDateTime") toDateTime:String,
//        @Query("userId")userId:Int?= null ,
//        @Query("mapId") mapId:Int?= null ,
//        @Query("beaconManageNumber") beaconManageNumber:String?= null ,
//        @Query("type") type:String?= null,
//        @Query("sortKey") sortKey:String?= null
//    ): Response<BeaconSearchResponse>
//
//    // User一覧
//    @GET("/api/work_user/search")
//    suspend fun getUserList(
//        @Query("userId") userId:String?= null  ,
//        @Query("userName") userName:String?= null ,
//        @Query("sortKey")sortKey:String?= null ,
//        @Query("sortOrder") sortOrder:String?= null ,
//        @Query("offset") offset:Long?= null ,
//        @Query("limit") limit:Long?= null
//    ): Response<WorkUserResponse>
//
//    // ワークスペース一覧
//    @GET("/api/work_area/search")
//    suspend fun getWorkSpaceList(
//        @Query("areaId") areaId:Int?= null  ,
//        @Query("areaName") areaName:String?= null ,
//        @Query("sortKey")sortKey:String?= null ,
//        @Query("sortOrder") sortOrder:String?= null ,
//        @Query("offset") offset:Long?= null ,
//        @Query("limit") limit:Long?= null
//    ): Response<WorkSpaceResponse>
//
//    //　オフィスマップ情報一覧
//    @GET("/api/map_office/search")
//    suspend fun getMapOfficeList(
//        @Query("sortKey")sortKey:String?= null ,
//        @Query("sortOrder") sortOrder:String?= null ,
//        @Query("offset") offset:Long?= null ,
//        @Query("limit") limit:Long?= null
//    ): Response<MapOfficeResponse>
//
//    // マップ情報取得
//    @GET("/api/map")
//    suspend fun getMapImage(
//        @Query("id") id:Int
//    ): Response<MapResponse>
//
//    // 勤怠情報更新
//    @PUT("/api/work_attendance")
//    suspend fun setWorkAttendance(@Body body: WorkAttendanceBody): Response<WorkAttendanceResponse>
//
//    // カメラ情報取得
//    @GET("/api/camera/search")
//    suspend fun getCameraList(
//        @Query("mapId") mapId:Int?= null,
//        @Query("areaId") areaId:Int?= null,
//        @Query("sortKey")sortKey:String?= null ,
//        @Query("sortOrder") sortOrder:String?= null ,
//        @Query("offset") offset:Long?= null ,
//        @Query("limit") limit:Long?= null
//    ): Response<CameraResponse>
//
//    // エリア一覧
//    @GET("/api/area/search")
//    suspend fun getAreaList(
//        @Query("mapId") mapId:Int
//    ): Response<AreaResponse>
//
//    // ジオフェンス一覧
//    @GET("/api/geofence")
//    suspend fun getGeofence(
//        @Query("id") id:Int
//    ): Response<GeofenceResponse>

}
