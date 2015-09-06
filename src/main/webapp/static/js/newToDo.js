var Equote = Equote || {};

Equote.init = function() {

    var data = null;

    function addListenr() {
        var $sumbit = $("#submit_todo");

        $sumbit.click(function(){
            console.log(getData());
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'type': 'POST',
                'url': "/v1/todo/add",
                'data': JSON.stringify(getData()),
                'dataType': 'json',
                'success': successHander
            });
        })
    }

    function successHander(result) {
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