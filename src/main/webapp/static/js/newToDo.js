var Equote = Equote || {};

Equote.init = function() {

    var data = null;

    function addListenr() {
        var $sumbit = $("#submit_todo");

        $sumbit.click(function(){
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
        })
    }

    function successHandle(result) {
        var $todos = $("#todos");
        var target ="";
        for(var i=0;i<result.length;i++) {
            target= target + "<div>" + result[i].name + "</div>";
        }
        $todos.empty();
        $(target).appendTo($todos);
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