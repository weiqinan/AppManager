//��������Ƿ���input��onchange�����ϵ�  �����ϴ���Ʒ�ĳ���ͼ
//suffix�������ͼƬ����ʱ���A,B,C
function uploadProduct(targetFileInputId){
	
    var filepath = document.getElementById(targetFileInputId).value;
    var re = /(\\+)/g;    
    var filename=filepath.replace(re,"#");
    var one=filename.split("#");   
    var two=one[one.length-1];   
    var three=two.split(".");   
    var last=three[three.length-1];   
    var tp ="jpg,gif,bmp,png,JPG,GIF,BMP,PNG";
    var rs=tp.indexOf(last);
   
    if(rs!=-1){
    	ajaxUploadProduct(targetFileInputId, suffix);
     	return true;  
     	
     }else{
     	alert("ֻ�ܹ��ϴ�jpg/gif/png/bmp��ʽ��ͼƬ");
     //$('#subbutton').attr("disabled", "disabled");   
         return false;
     }
}

function ajaxUploadProduct(targetFileInputId) {  
	
	//��ȡһ���û��������Ʒ��partnumber
	var partnumber = $("#partnumberInput").val();
	
	if (partnumber == null || partnumber.length <=0) {
		alert("����������Ʒ���");
		return;
	} else {
		partnumber = Trim(partnumber);
	}
	
	//�����ʼ�ˣ��Ͱ�ͼ�滻��loading
	var imgId = "productPic" + suffix;
    $("#" + imgId).attr("src", "images/loading.gif");
    $("#mask" + suffix).css("display", "none");
    $("#desc" + suffix).css("display", "none");
    
    $.ajaxFileUpload
    (  
	     { 
	        url: '../PortalUploadPordPic',
	        secureuri: false,  
	        fileElementId: targetFileInputId,
	        type: "POST",
	        dataType: 'json',
	        data:{
	            "partnumber": partnumber,
	            "suffix":  suffix
	        },
	        success: function(data, status) {
	           // var url="<%=pageContext.getAttribute("jsAssetsDir")%>"+"/interaction/sungoodspic/small/"+data.fileName;
	           $("#" + imgId).attr("src", data.path);
	           $("#mask" + suffix).css("display", "none");
	           $("#desc" + suffix).css("display", "none");
	           $("#del" + suffix).css("display", "block");
	        },  
	        error: function(data, status, e) {  
	            alert(e);
	        }
	    }
	)  
	return false;
}