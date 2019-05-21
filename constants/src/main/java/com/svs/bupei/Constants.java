package com.svs.bupei;

public abstract class Constants {

    /**
     * 视频存储地址
     */
    public static final String SAVE_PATH = "D:\\VadioHome\\";

    /**
     * 视频支持类型
     */
    public static final String VADIO_TYPE = "rm，rmvb，mov，mtv，dat，wmv，avi，3gp，amv，dmv，flv，mp4";

    /**
     * 视频没有上传
     */
    public static final String ERROR_NOTHING_VADIO = "您还没有上传视频!";

    /**
     * 上传视频过大
     */
    public static final String ERROR_AROUND_VADIO = "上传的视频不可超过100MB";

    /**
     * 上传的文件有误，请重试
     */
    public static final String ERROR_UPLOAD_VADIO = "上传的文件有误，请重试(目前视频格式只支持rm，rmvb，mov，mtv，dat，wmv，avi，3gp，amv，dmv，flv，mp4)";

    /**
     * 上传信息不完整
     */
    public static final String ERROR_MESSAGE_NOT_FULL = "您上传的信息不完整或有误，请重试~~";

    /**
     * 上传视频信息失败
     */
    public static final String ERROR_UPLOAD = "上传失败，视频未写入";

    /**
     * 上传视频信息成功
     */
    public static final String SUCCESS_UPLOAD = "上传成功！！！";

    /**
     * 添加成功
     */
    public static final String SUCCESS_INSERT = "添加操作成功";

    /**
     * 添加失败
     */
    public static final String ERROR_INSERT = "添加操作失败，请重试";

    /**
     * 删除操作成功
     */
    public static final String SUCCESS_DELETE = "删除成功！！！";

    /**
     * 删除操作失败
     */
    public static final String ERROR_DELETE = "删除失败";

    /**
     * 更改操作成功
     */
    public static final String SUCCESS_UPDATE= "更改成功！！！";

    /**
     * 更改操作失败
     */
    public static final String ERROR_UPDATE = "更改失败";


    /**
     * 图片存储地址
     */
    public static final String SAVE_PATH_LOGO = "F:\\LogoHome\\";

    /**
     * 图片支持类型
     */
    public static final String LOGO_TYPE = ".png，.bmp，.jpeg，.jpg,.psd，.tmp";

    /**
     * 图片没有上传
     */
    public static final String ERROR_NOTHING_LOGO= "您还没有上传头像!";

    /**
     * 上传头像过大
     */
    public static final String ERROR_AROUND_LOGO = "上传的头像过大";

    /**
     * 上传的文件有误，请重试
     */
    public static final String ERROR_UPLOAD_LOGO = "上传的文件有误，请重试";

    /**
     * 没有找到举报的视频
     */
    public static final String NOTHING_VADIO = "很抱歉，没有找到您所举报的视频";

    /**
     * rsuccess傳值不正確
     */
    public static final String ERROR_RSUCCESS = "success傳值不正確,只可以傳已同意或未同意";
}
