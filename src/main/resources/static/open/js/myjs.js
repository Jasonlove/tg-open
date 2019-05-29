

function FreshTime()
{
	var time=$("#time_x").val();
	//alert(time)
    var endtime=new Date(time);//结束时间
    //alert(endtime)
    var nowtime = new Date();//当前时间
    var lefttime= parseInt((endtime.getTime()-nowtime.getTime())/1000); 
    d=parseInt(lefttime/3600/24); ;
    h= parseInt(lefttime/(60*60))%24 ;
    m= parseInt(lefttime/(60))%60 ;
    s= parseInt(lefttime%60);
   
    //document.getElementById("LeftTime").innerHTML=d+"天"+h+"小时"+m+"分"+s+"秒";
    $("#LeftTime").html(d+"<em>天</em>"+h+"<em>小时</em>"+m+"<em>分</em>"+s+"<em>秒</em>");
   
    if(lefttime <=0){
	    document.getElementById("LeftTime").innerHTML="团购已结束";
	    clearInterval(sh);
	    $(".con_bottom .btn_left").css("display","none");
	    $(".con_bottom .btn_right").css("display","none");
	    $(".tg_p div").css("margin-bottom","80px")
    }
}
FreshTime()
var sh;
sh=setInterval(FreshTime,1000);



