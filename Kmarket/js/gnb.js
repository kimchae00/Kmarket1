/*
$(document).ready(function(){
       
        $('#gnb').hover(function(){
            $(this).animate({'height':'0'}, 1000);
        });
        $('#gnb').hover(function(){
            $(this).animate({'height':'200px'}, 1000);
        });
});
*/



$(document).ready(function(){
    var gnb = $('#gnb > li > a');

    gnb.click(function(e){
        e.preventDefault();
        
        var isOpen = $(this).next().is(':visible');

        if(isOpen){
            // 현재 서브메뉴를 닫음
            $(this).next().slideUp(200);
        }else{
            // 현재 서브메뉴를 펼침
            $(this).next().slideDown(200);
        }
    });
});
