项目版本-------1.0.0

本次项目采用eureka作为注册中心来进行项目搭建
项目后台分为四大模块
    1.登陆注册模块（用户模块）:user-com.svs.bupei.vadio.mapper.service
    2.视频模块:com.svs.bupei.vadio-com.svs.bupei.vadio.mapper.service
    3.商家与订单模块（库存与订单）:order-com.svs.bupei.vadio.mapper.service
    4.杂项（举报与自动回复等）:com.svs.bupei.vadio.other-com.svs.bupei.vadio.mapper.service

关于port:
    上方1模块所有的port采用5000-5999进行设置
    上方2模块所有的port采用6000-6999进行设置
    上方3模块所有的port采用7000-7999进行设置
    上方4模块所有的port采用8000-8999进行设置
    搭建的eureka port为10100
    zuul为10200

命名规则：
    所有子项目一律采用 模块名-com.svs.bupei.vadio.mapper.service 来进行命名(名字上方模块分类已给)
    所有子项目的spring.application.name一律采用 模块名-com.svs.bupei.vadio.mapper.service 来进行命名
    所有子项目中的类名要用该表明进行命名:如用户表的mapper就是UserMapper，类名开头字母一定大写
    所有类中的增删改查方法访问必须按照/表名/增删改查（如 select-all，如果是查询其他表就是 select-某表，但是这种方法最好写到你想要查询的那个表里）
    建议：所有的mapper统一放到一个mapper包下，controller统一放到controller包下

    项目版本-------1.0.4

    本次更新：
        视频模块与杂项所有功能全部实现

    本次项目采用eureka作为注册中心来进行项目搭建
    项目后台分为四大模块
        1.登陆注册模块（用户模块）:user-service
        2.视频模块:vadio-service
        3.商家与订单模块（库存与订单）:order-service
        4.杂项（举报与自动回复等）:other-service

    关于port:
        上方1模块所有的port采用5000-5999进行设置
        上方2模块所有的port采用6000-6999进行设置
        上方3模块所有的port采用7000-7999进行设置
        上方4模块所有的port采用8000-8999进行设置
        搭建的eureka port为10100

    命名规则：
        所有子项目一律采用 模块名-service 来进行命名(名字上方模块分类已给)
        所有子项目的spring.application.name一律采用 模块名-service 来进行命名
        所有子项目中的类名要用该表明进行命名:如用户表的mapper就是UserMapper，类名开头字母一定大写
        所有类中的增删改查方法访问必须按照/表名/增删改查（如 select-all，如果是查询其他表就是 select-某表，但是这种方法最好写到你想要查询的那个表里）
        建议：所有的mapper统一放到一个mapper包下，controller统一放到controller包下


    已有功能：
    vadio视频表:
        查询vadio表("/vadio/selectAllVadio" method = "post")
        其中逻辑：
            按推送优先级降序排列查询
        所需数据:
            int limit:每页显示条数
            int page:页数
            String vname:按视频名模糊查询
            String vtype:按视频种类模糊查询
            String uname:按商家名模糊查询
            String vsuccess:查询通过视频（已通过或未通过,默认查询已通过）
            String vdelete:查询删除视频(已删除或未删除,默认查询未删除)
        返回map键值对:
            data:模糊查询后的所有数据
            count:当前数据个数
            msg:当vsuccess和vdelete的值不正确时将返回字符串：传值不正确



        添加vadio表("/vadio/insertVadio" method = "post")
        其中逻辑:
            增加一条vadio表数据
        所需数据:
            part vadio:视频流
            string vname:视频名字
            string vtype:视频类型
            string uname:用户或商家名字
            string vdate（前台可以自己捕捉系统时间）:上传时间
        返回map键值对
            msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

        添加vadio表("/vadio/deleteVadio/{vid}" method = "delete")
        其中逻辑:
            删除一条vadio表数据
        所需数据:
            在链接传值就好
        返回map键值对
            msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

        更改vadio表("/vadio/updateVadio" method = "post")
        其中逻辑:
            更改一条vadio表数据
        所需数据:
            vname:视频名字
            vtype:视频类型
            vid:视频编号
        返回map键值对
            msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

        给一个视频增加推送值("/vadio/addVadioVlv/{vid}" method = "put"):
        其中逻辑:
            先搜索该视频是否到达满级五级，如果没到达则增加，如果到达则返回错误信息
        所需数据:
                链接中传
            返回map键值对
                msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

    vclick视频点击量表:
        查询vclick表("/vclick/selectAllVclick" method = "post")
            其中逻辑：
                无
            所需数据:
                int limit:每页显示条数
                int page:页数
                String vcuname:按用户模糊查询该用户的点击历史记录
            返回map键值对:
                data:模糊查询后的所有数据
                count:当前数据个数

        添加vclick表("/vclick/insertVclick" method = "post")
                其中逻辑：
                    无
                所需数据:
                    vcdate:当前系统时间
                    vcuname:当前用户名字
                    vid:视频主键vid
                返回map键值对:
                    msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)
    good点赞表:
        查询good表("/good/selectAllGood" method = "post")
                其中逻辑：
                    无
                所需数据:
                    int limit:每页显示条数
                    int page:页数
                    String uname:按用户模糊查询该用户的点赞历史记录(与vid二者传一即可，一个是按视频查，一个是按用户查询)
                    int vid:按视频查询该视频的被赞信息
                返回map键值对:
                    data:模糊查询后的所有数据
                    count:当前数据个数

        添加或删除good表("/good/insertAndDeleteGood" method = "post")
                    其中逻辑：
                        当调用这个方法的时候会先根据用户和视频id查询该用户是否点赞过该视频，如果点赞过则删除点赞，如果没有点赞过,则添加一条点赞信息
                    所需数据:
                        gdate:点赞时间
                        gnum:点赞内容(0为好评1为差评)
                        uname:点赞用户
                        vid:点赞视频主键
                    返回map键值对:
                        msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)
    answer商家自动回复表:
        查询answer表("/answer/selectAllAnswer" method = "post")
                其中逻辑：
                    无
                所需数据:
                    int limit:每页显示条数
                    int page:页数
                    String uname:按用户模糊查询该用户设置的所有自动回复信息
                返回map键值对:
                    data:模糊查询后的所有数据
                    count:当前数据个数

        添加answer表("/answer/insertAnswer" method = "post")
            其中逻辑:
                增加一条answer表数据
            所需数据:
                String uname:用户
                String akeyword:关键字
                String atext:回复内容
            返回map键值对
                msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

        删除answer表("/answer/deleteAnswer/{aid}" method = "delete")
                其中逻辑:
                    删除一条answer表数据
                所需数据:
                    在连接中传
                返回map键值对
                    msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

        修改answer表("/answer/updateAnswer" method = "post")
                    其中逻辑:
                        修改一条answer表数据
                    所需数据:
                        int aid:主键
                        String akeyword:关键字
                        String atext:回复内容
                    返回map键值对
                        msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)
    question视频评论表:
        查询question表("/question/selectAllQuestion" method = "post")
                    其中逻辑：
                        无
                    所需数据:
                        int limit:每页显示条数
                        int page:页数
                        String uname:按用户模糊查询该用户所有评论
                        String vid:按视频查询该视频所有评论
                        String qdelete:按是否被删除查询(默认查询未删除)
                    返回map键值对:
                        data:模糊查询后的所有数据
                        count:当前数据个数
                        msg:如果传值错误会返回错误信息

            添加question表("/question/insertQuestion" method = "post")
                其中逻辑:
                    增加一条question表数据
                所需数据:
                    int vid:视频主键
                    String qtext:评论内容
                    String uname:评论者
                    String qdate:评论日期
                返回map键值对
                    msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

            删除question表("/question/deleteQuestion/{qid}" method = "delete")
                    其中逻辑:
                        并不是真正的删除，只是把数据库中qdelete信息改为已删除
                    所需数据:
                        在连接中传
                    返回map键值对
                        msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

            修改question表("/question/updateQuestion" method = "post")
                        其中逻辑:
                            修改一条question表数据
                        所需数据:
                            int qid:主键
                            String qtext:修改后的回复内容
                            String qdate:修改后日期
                        返回map键值对
                            msg:操作后信息(如上传成功，上传失败等，具体信息请看vadio-service下面的com.svs.bupei.other.Constants.java)

            根据评论主键返回被评论视频所有信息("/question/selectVadioByQuestion/{qid}" method = "put")
                        其中逻辑:
                            根据评论主键返回被评论视频所有信息
                        所需数据:
                            链接中传
                        返回map键值对
                            data:视频所有信息
                            msg:如果视频被删除就会返回错误信息
    report举报视频表:
        查询report表("/report/selectAllReport" method = "post")
                        其中逻辑：
                            无
                        所需数据:
                            int limit:每页显示条数
                            int page:页数
                            String uname:按用户模糊查询该用户所有举报信息
                            int vid:按视频查询该视频所有举报信息
                            String rsuccess:查询同意或者未同意或者待处理的举报信息（可不传此值，默认查找待处理的举报信息）
                        返回map键值对:
                            data:模糊查询后的所有数据
                            count:当前数据个数
        添加report表("/report/insertReport" method = "post")
                    其中逻辑:
                        增加一条report表数据
                    所需数据:
                        int vid:被举报视频主键
                        String uname:举报用户
                        String rtext:举报内容
                        String rdate:举报日期
                    返回map键值对
                        msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

        删除report表("/report/deleteReport/{rid}" method = "delete")
                        其中逻辑:
                            用于用户取消举报
                        所需数据:
                            在连接中传
                        返回map键值对
                            msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

        管理员修改report表("/report/managerUpdateReport" method = "post")
                            其中逻辑:
                                将一条举报信息改为已同意或者未同意，如果已同意则将vadio表的该视频删除
                            所需数据:
                                int rid:举报主键
                                String rsuccess:已同意或者未同意
                            返回map键值对
                                msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

    reporttext举报评论表:
        查询reporttext表("/reporttext/selectAllReportText" method = "post")
                            其中逻辑：
                                无
                            所需数据:
                                int limit:每页显示条数
                                int page:页数
                                String uname:按用户模糊查询该用户所有举报信息
                                String rsuccess:查询同意或者未同意或者待处理的举报信息（可不传此值，默认查找待处理的举报信息）
                            返回map键值对:
                                data:模糊查询后的所有数据
                                count:当前数据个数
            添加reporttext表("/reporttext/insertReportText" method = "post")
                        其中逻辑:
                            增加一条report表数据
                        所需数据:
                            int qid:被举报评论主键
                            String uname:举报用户
                            String rtext:举报内容
                            String rdate:举报日期
                        返回map键值对
                            msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

            删除reporttext表("/reporttext/deleteReportText/{reid}" method = "delete")
                            其中逻辑:
                                用于用户取消举报
                            所需数据:
                                在连接中传
                            返回map键值对
                                msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

            管理员修改requestText表("/reporttext/managerUpdateReportText" method = "post")
                                其中逻辑:
                                    将一条举报信息改为已同意或者未同意，如果已同意则将question表的该视频删除
                                所需数据:
                                    int reid:举报主键
                                    String resuccess:已同意或者未同意
                                返回map键值对
                                    msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

    user用户表:
        查询user表("/user/show" method = "post")
                            其中逻辑：
                                无
                            所需数据:
                                int limit:每页显示条数
                                int page:页数
                            返回map键值对:
                                data:模糊查询后的所有数据
                                count:当前数据个数
            添加user表("/user/save" method = "post")
                        其中逻辑:
                            增加一条user表数据
                        返回map键值对

            删除reporttext表("/user/delete" method = "delete")
                            其中逻辑:
                                用于用户取消举报
                            所需数据:
                                在连接中传uid
                            返回map键值对
                                msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

            管理员修改user表("/user/update" method = "post")
                                所需数据:
      			账号username，密码pwd，昵称uname（不可重复），客户类别utype（用户或商家），联系电话ucall，微信号uwei，地址uaddress，头像ulogo（可空），详细介绍usuggest，是否vip uvip，注册时间udate，
                                返回map键值对
                                    msg:操作后信息(如上传成功，上传失败等，具体信息请看other-service下面的com.svs.bupei.other.Constants.java)

    	查询所有user表按账号密码("/user/selectAll" method = "post")
    		所需数据:
    			账号：username
    			密码：pwd

        	查询user表格手机号是否被使用("/user/selectucall" method = "post")
    		所需数据:
    			手机号：ucall

    	查询user表格昵称是否被使用("/user/selectuname" method = "post")
    		所需数据:
    			昵称：uname

    	查询user表格用户名是否被使用("/user/selectusername" method = "post")
    		所需数据:
    			用户名：username，


    buy买卖表格（buy与depot同属于depot-service）

    	查询buy表格("/buy/show" method = "post")
    		 所需数据
    		   	 int limit:每页显示条数
                               		 int page:页数
    	删除buy表格("/buy//delete" method = "delete")
    		所需数据：bid
    	修改buy表格("/buy//update" method = "post")
    		所需数据：bid
    			所需数据：买家buname，卖家uname，交易份数bnum，交易总金额bmoney，交易时间bdate，买家地址baddress，买家联系电话bcall，买家真实姓名bname，货物情况btype（包括0未到，1已到，2申请退款，3退款成功，4拒绝）
    	增加buy表格("/buy//save" method = "post")
    		所需数据：买家buname，卖家uname，交易份数bnum，交易总金额bmoney，交易时间bdate，买家地址baddress，买家联系电话bcall，买家真实姓名bname，货物情况btype（包括0未到，1已到，2申请退款，3退款成功，4拒绝退款）
    		注意：成功返回总价钱,,//但是添加成功后无法修改depot表格库存数量，需要获取数量调用updatednum方法

    	修改buy表格("/buy/updatednum" method = "post")
    		//当卖出货物时Depot库存减少，修改depot 表格库存的方法

    depot库存表格（buy与depot同属于depot-service）

    	查询buy表格("/depot/show" method = "post")
    		所需数据：
    		   	 int limit:每页显示条数
                               		 int page:页数
    	删除depot表格("/depot//delete" method = "delete")
    		所需数据：bid
    	修改depot表格("/depot//update" method = "post")
    		所需数据：bid
    	增加depot表格("/depot//save" method = "post")
    		所需数据：主键did，所属卖家uname，货物名字dname，货物种类dtype，货物单价dprice，货物库存剩余doverplus（所有货物单位为件），是否出售dsell（0否，1是）

    	查询货物剩余个数buy表格("/depot/showdnum" method = "post")
    		所需数据：
    		   	 货物名称：dname
    	 查询商家货物名称是否重复buy表格("/depot/showdnum" method = "post")
    		所需数据：
    		   	商家：uname
    			货物名称：dname

    	 按商家查询货物种类buy表格("/depot/selectdtype" method = "post")
    		所需数据：

    		   	商家：uname
    			货物名称：dname
    	按商家查询未开始出售的货物buy表格("/depot/selectdsell" method = "post")
    		所需数据：

    		   	货物状态：dsell=0







