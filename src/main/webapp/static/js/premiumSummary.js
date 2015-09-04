var Equote = Equote || {};


Equote.premium = function(){
    var movies = [
        { Name: "The Red Violin", ReleaseYear: "1998" },
        { Name: "Eyes Wide Shut", ReleaseYear: "1999" },
        { Name: "The Inheritance", ReleaseYear: "1976" }
    ];
    var markup = "<li><b>${lifeCoverPremium}</b></li><li><b>${policyFee}</b></li>";


    function init() {
        fetchData();

    }

    function insertData(data) {
        $.template( "movieTemplate", markup );
        $.tmpl( "movieTemplate", data )
            .appendTo( "#premiumSummary" );
    }

    function fetchData() {
        $.ajax({
            url:"/pricing/calculate",
            data:{},
            type:"POST",
            success:insertData
        })

    }
    return {
        fetchData:fetchData,
        startup:init
    }
};