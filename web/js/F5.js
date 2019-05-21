 window.onbeforeunload = function(){
            document.documentElement.scrollTop = 0;  //ie下
            document.body.scrollTop = 0;  //非ie
 }
