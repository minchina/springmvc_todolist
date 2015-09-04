var Equote = Equote || {};


Equote.premium = function(){
    var movies = [
        { Name: "The Red Violin", ReleaseYear: "1998" },
        { Name: "Eyes Wide Shut", ReleaseYear: "1999" },
        { Name: "The Inheritance", ReleaseYear: "1976" }
    ];
    var markup = "<li><b>${lifeCoverPremium}</b></li><li><b>${policyFee}</b></li>";


    function init() {
        fetchData(insertData);

    }

    function insertData(data) {
        $.template( "movieTemplate", markup );
        $.tmpl( "movieTemplate", data )
            .appendTo( "#premiumSummary" );
    }

    function fetchData(target) {
        $.ajax({
            url:"/pricing/calculate",
            data:{},
            type:"POST",
            success:function(data){
                target(data);
            }
        })

    }
    return {
        fetchData:fetchData,
        startup:init
    }
};