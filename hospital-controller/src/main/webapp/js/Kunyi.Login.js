Kunyi.GetQueryString=function(key){
   var reg = new RegExp("(^|&)"+ key +"=([^&]*)(&|$)");
   var r = window.location.search.substr(1).match(reg);
   if(r!=null)return  unescape(r[2]); return null;
}
$(function(){	
	$("#LoginForm").Validform({
		tiptype:3,
		showAllError:true,
		postonce:true,
		ajaxPost:true,
		datatype:{
			"zh2-2": /^[\u4E00-\u9FA5\uf900-\ufa2d]{2}$/,
			"idcard":function(gets,obj,curform,datatype){
				var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];// 加权因子;
				var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];// 身份证验证位值，10代表X;
			
				if (gets.length == 18){   
					var a_idCard = gets.split("");// 得到身份证数组   
					if (isValidityBrithBy18IdCard(gets)&&isTrueValidateCodeBy18IdCard(a_idCard)) {   
						return true;   
					}   
					return false;
				}
				return false;
				function isTrueValidateCodeBy18IdCard(a_idCard) {   
					var sum = 0; // 声明加权求和变量   
					if (a_idCard[17].toLowerCase() == 'x') {   
						a_idCard[17] = 10;// 将最后位为x的验证码替换为10方便后续操作   
					}   
					for ( var i = 0; i < 17; i++) {   
						sum += Wi[i] * a_idCard[i];// 加权求和   
					}   
					valCodePosition = sum % 11;// 得到验证码所位置   
					if (a_idCard[17] == ValideCode[valCodePosition]) {   
						return true;
					}
					return false;   
				}
				function isValidityBrithBy18IdCard(idCard18){   
					var year = idCard18.substring(6,10);   
					var month = idCard18.substring(10,12);   
					var day = idCard18.substring(12,14);   
					var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
					if(temp_date.getFullYear()!=parseFloat(year) || temp_date.getMonth()!=parseFloat(month)-1 || temp_date.getDate()!=parseFloat(day)){   
						return false;   
					}
					return true;   
				}
			}
		},
		beforeSubmit:function(curform){
			$("#btnLogin").val("登录中...");
			$("#btnLogin").attr("disabled","disabled");
		},
		callback:function(data){
			$("#btnLogin").val("登录");
			$("#Validform_msg").hide();
			if(data.status=="y"){
				    if(data.info=="true"){
						var URL=Kunyi.GetQueryString("redirectURL");
						if(URL !=null && URL.toString().length>1&&URL.indexOf("http")<0){
							window.top.document.location.href=URL;
						}else{
				        window.top.document.location.href ="ChooseOffice.html";
						}
					}else{
					window.top.document.location.href ="BindPhone.html";
					}
			}else{
				$("#tbHashReg").val(data.hash);
				Kunyi.Msg.ShowTipsMsg(data.info,"1888","2");
				$("#btnLogin").removeAttr("disabled");
			}
			$("#IMGCheckcode").click();
		}
	});
})