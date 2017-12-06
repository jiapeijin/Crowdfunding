$(function() {

	/*企业关注操作*/
    $('.relativeInfo').on('mouseenter','.viewBox i',function(){
        $(this).next().css('display','block');
    }).on('mouseleave','i',function(){
        $(this).next().css('display','none');
    }).on("click",".viewBox i",function(){
    	var $this = $(this);
        var cname = $(this).attr("id");
        var setUrl = "/gyy/restBusiness/setComFollow";
        var cancelUrl = "/gyy/restBusiness/updateComFollow";
        var url = null;
		if ($(this).hasClass("current")) {
			url = cancelUrl;
		} else {
			url = setUrl;
		}
		var isSuccess = false;
        $.ajax({
            url: url,
            dataType: 'json',
            type: 'post',
            data: {
                comName : cname,
				cname : cname
			},
            success: function (data) {
				if (data.success) {
                    $this.toggleClass('current');
                    if (url == setUrl) {
                        $this.next("span").text("取消关注");
                    } else if (url == cancelUrl) {
                        $this.next("span").text("关注");
                    }

				}

            }
        });
    });


    // //收起-折叠
    // $('.factorWrap .single').each(function(index,val) {
    //     if ($(this).height() > 40) {
    //         $(this).find('.factor').height(40);
    //         $(this).append('<a class="downBtn">查看更多</a><a class="upBtn">收起</a>');
    //     }
    //     $('.factorWrap .single').on('click', 'a', function () {
    //         if ($(this).index() == 1) {
    //             $(this).prev().height('');
    //         } else {
    //             $(this).siblings('.factor').height(40);
    //         }
    //         $(this).css('display', 'none').siblings('a').css('display', 'block');
    //     })
    // });

    reAdjustColumnWidth();

});

//单选single
function singleSelect(spanItem) {
    if(!$(spanItem).hasClass('active')){
        $(spanItem).addClass('active').prev().attr('checked','checked').siblings('input').attr('checked',false).next('span').removeClass('active');
        $('.selected').append('<span class="selectedTerm" id="'+$(spanItem).prev().val()+'">'+$(spanItem).text()+'<i></i></span>');
        $(spanItem).prev().siblings('input').each(function(){
            var that=$(this).val();
            $('.selectedTerm').each(function(index,val){
                if($(this).attr('id')==that){
                    $(this).remove();
                }
            });
        })

    }else{
        $(spanItem).removeClass('active').prev().attr('checked',false);
        var value=$(spanItem).prev().val();
        $('.selectedTerm').each(function(index,val){
            if($(this).attr('id')==value){
                $(this).remove();
            }
        })
    }
    checkEmptySelected();
}
//多选multiselect
function multiSelect(spanItem) {

    if(!$(spanItem).hasClass('active')) {
        $(spanItem).addClass('active').prev().prop('checked','checked');
        $('.selected').append('<span class="selectedTerm" id="' + $(spanItem).prev().val()+'">' + $(spanItem).text() + '<i></i></span>');
    } else {
        $(spanItem).removeClass('active').prev().prop('checked',false);
        var val = $(spanItem).prev().val();
        $('.selectedTerm').each(function(){
            if($(this).attr('id') == val){
                $(this).remove();
            }
        })
    }
    checkEmptySelected();
}

//点击删除指定已选条件
function delSelectedCondition(iItem) {
    var val = $(iItem).parent().attr('id');
    $('.factor input').each(function(){
        if($(this).val()==val){
            $(this).attr('checked',false).next().removeClass('active');
        }
    });
    $('.single input').each(function(){
        if($(this).val()==val){
            $(this).attr('checked',false).next().removeClass('active');
            $(this).next().siblings('span').css('color','#333');
        }
    })
    $(iItem).parent().remove();
    checkEmptySelected();
}
//点击排序
function orderClick(spanItem) {
    $(spanItem).toggleClass('active');
    if($(spanItem).hasClass('active')){
        $(spanItem).siblings('span').removeClass('active').prev().prop('checked',false);
        $(spanItem).prev().prop('checked','checked');
    }else{
        $(spanItem).removeClass('active').prev().prop('checked',false);
    }
}
//重新调整列宽(根据表格列数进行调整，
// 如果列数少于5，取table_width/column_number，否则，列宽取固定值200)
function reAdjustColumnWidth() {
    var i=$('.itemContent table th').length;
    if(i<=5){
        $('.itemContent').css('width','100%');
        $('.itemContent table th').width($('.itemContent').width()/i);
    }else{
        $('.itemContent table th').width(200);
        $('.itemContent').width(i*200);
    }
}

//收起或展开筛选条件
function pickUpOrSpreadConditions($thisItem, innerDivClassName) {
    if ($($thisItem).height() > 40) {
        $($thisItem).find(innerDivClassName).height(40);
        $($thisItem).append('<a class="downBtn">查看更多</a><a class="upBtn">收起</a>');
    }
    $($thisItem).on('click', 'a', function () {
        if ($(this).index() == 1) {
            $(this).prev().height('');
        } else {
            $(this).siblings(innerDivClassName).height(40);
        }
        $(this).css('display', 'none').siblings('a').css('display', 'block');
    });
}

function checkEmptySelected(){

    if($('.selected').find('.selectedTerm').length!=0){

        $('.resetTerm').css('display','block');
    }else{
        $('.resetTerm').css('display','none');
    }
}