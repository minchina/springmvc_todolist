var Equote = Equote || {};

Equote.init = function() {

    var data = null;
    var $newTodoTemplate = $('#newTodoTemplate');

    function addListenr() {

        var $sumbit = $("#submit_todo");
        var $test_impl = $('#test_tmpl');

        $sumbit.click(function(){

            console.log("123");
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'type': 'POST',
                'url': "/v1/todo/add",
                'data': JSON.stringify(getData()),
                'dataType': 'json',
                'success': successHandle
            });
        });

        $test_impl.click(function(event){
            alert("hello,world");
        })
    }

    function successHandle(result) {
        $("#test_format").empty();

        $newTodoTemplate.tmpl({}).appendTo("#test_format");
        addListenr();
        console.log(result);
    }

    function getData() {
        if(data == null) {
            data = $("#test_format").formality();
            return data;
        }
        return data;
    }

    return {
        addListenr:addListenr,
        data: getData
    }

};