$(function () {

    var data = {
        login:"",
        password:""
    };

    $("#loginForm").dxForm({
        formData:data,
        items: [{
            dataField: "login",
            label: {
                location: "top",
                alignment: "left",
                text: "Login"
            }
        },{
            dataField: "password",
            editorOptions: {
                mode: 'password'
            },
            label: {
                location: "top",
                size:"20px",
                alignment: "left",
                text: "Hasło"
            }
        }]
    });

    $("#loginButton").dxButton({
        text: "Zaloguj",
        width: "100px",
        type: "normal",
        onClick: function (e) {
            var loginForm = $("#loginForm").dxForm('instance');
            var logform = {
                username: loginForm.getEditor('login').option('value'),
                password: loginForm.getEditor('password').option('value')
            };


            /*$.post('./api/auth/signin?login=' + logform.username + '&password=' + logform.password, function (result) {
            }).done(function (e) {

            })*/

        }
    });



});
