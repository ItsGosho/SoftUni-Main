function validate() {
    $(`#company`).prop("checked","");
    $(`#company`).change(function () {
        if($(this).prop("checked")===true){
            $(`#companyInfo`).css("display","");
        }else{
            $(`#companyInfo`).css("display","none");
        }
    });


    $("#registerForm").submit(function(e) {
        e.preventDefault();
    });
    $(`#submit`).on('click',function () {
        let isValid=true;
        let regexUsername = new RegExp("^([a-zA-Z0-9]{3,20})$");
        let matchUsername = regexUsername.exec($(`#username`)[0].value);

        if(!matchUsername){
            $(`#username`).css("border-color","red");
            isValid=false;
        }else{
            $(`#username`).css("border-color","none");
        }

        let regexPassword = new RegExp("^([a-zA-Z0-9_]{5,15})$");

        let matchPassword = regexPassword.exec($(`#password`)[0].value);
        let matchConfirmPassword = regexPassword.exec($(`#confirm-password`)[0].value);
        if($(`#password`)[0].value===$(`#confirm-password`)[0].value){
            if(matchPassword && matchConfirmPassword){
                $(`#password`).css("border-color","none");
                $(`#confirm-password`).css("border-color","none");
            }else{
                isValid=false;
                $(`#password`).css("border-color","red");
                $(`#confirm-password`).css("border-color","red");
            }
        }else{
            isValid=false;
            $(`#password`).css("border-color","red");
            $(`#confirm-password`).css("border-color","red");
        }


        let regexEmail = new RegExp("^([a-zA-Z0-9]+)(@{1})([a-zA-Z0-9]{0,11111})(\\.){1}([a-zA-Z0-9]{0,11111})$");
        let matchEmail = regexEmail.exec($(`#email`)[0].value);
        if(matchEmail){
            $(`#email`).css("border-color","none");
        }else{
            isValid=false;
            $(`#email`).css("border-color","red");
        }

        if($(`#company`).prop("checked")){
            if(Number($(`#companyNumber`)[0].value)>=1000 && Number($(`#companyNumber`)[0].value)<=9999){
                $(`#companyNumber`).css("border-color","none");
            }else{
                isValid=false;
                $(`#companyNumber`).css("border-color","red");
            }
        }


        if(isValid){
            $(`#valid`).css("display","inline");
        }else{
            $(`#valid`).css("display","none");
        }
    });
}