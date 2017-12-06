$(function(){
	//placeholder兼容ie8
	$('input, textarea').placeholder();


	windowHeight();
	$(window).resize(function(){
        windowHeight();
    })
		
	/*招商管理首页*/
	$('.relationInfo').on('mouseenter','span',function(){
		$(this).css('background','#eee');
	}).on('mouseleave','span',function(){
        $(this).css('background','#fff');
    });


	/*返回顶部*/
	$(window).scroll(function(){
		if($(window).scrollTop()>=800){
			$('.topBtn').css('display','block');
		}
	});
	$('.topBtn').click(function(){
		var currentH=$(window).scrollTop();
		if(currentH<=2000){
			var timer1=setInterval(function(){
				var hh=$(window).scrollTop()-10;
				$(window).scrollTop(hh);
				if(hh<=5){
					clearInterval(timer1);
					$('.topBtn').css('display','none');
				}
			},10);
		}else if(2000<currentH && currentH<=5000){
			var timer2=setInterval(function(){
				var hh=$(window).scrollTop()-50;
				$(window).scrollTop(hh);
				if(hh<=5){
					clearInterval(timer2);
					$('.topBtn').css('display','none');
				}
			},10);
		}else if(5000<currentH && currentH<=10000){
			var timer3=setInterval(function(){
				var hh=$(window).scrollTop()-100;
				$(window).scrollTop(hh);
				if(hh<=5){
					clearInterval(timer3);
					$('.topBtn').css('display','none');
				}
			},10);
		}else if(currentH>10000){
			$(window).scrollTop(0);
		}
	});

	/*招商管理页的多选、单选选项展开收起*/
    // $('.factorWrap .wrap').each(function(index,val){
    //     if($(this).height()>40){
    //         $(this).find('.factor').height(40);
    //         $(this).append('<a class="downBtn">查看更多</a><a class="upBtn">收起</a>');
    //     }
    //     $('.factorWrap .wrap').on('click','a',function(){
    //         if($(this).index()==1){
    //             $(this).prev().height('');
    //         }else{
    //             $(this).siblings('.factor').height(40);
    //         }
    //         $(this).css('display','none').siblings('a').css('display','block');
    //     })
    // })

	/*招商管理首页企业库*/
	/*$('.factor').on('click','span',function(){
		if(!$(this).hasClass('active')){
			$(this).addClass('active').prev().attr('checked','checked');
			$('.selected').append('<span class="selectedTerm" id="'+$(this).prev().val()+'">'+$(this).text()+'<i></i></span>');
		}		
	})*/
	/*//多选
	 $('.factor').each(function(index,val){
	 	$(this).on('click','span',function(){
		if(!$(this).hasClass('active')){
				$(this).addClass('active').prev().attr('checked','checked');
	 			$('.selected').append('<span class="selectedTerm" id="'+$(this).prev().val()+'">'+$(this).text()+'<i></i></span>');
	 		}else{
	 			$(this).removeClass('active').prev().attr('checked',false);
				var val=$(this).prev().val();
				$('.selectedTerm').each(function(){
					if($(this).attr('id')==val){
						$(this).remove();
					}
				})
			}
	 		windowHeight();
		})
	 })
	//单选
	 $('.single ').on('click','span',function(){
	 	var len = checkLength($(this).parent().find('input'));
	 	if(len==0){
	 		$(this).siblings('span').css('color','#999');
			$(this).addClass('active').prev().attr('checked','checked');
			$('.selected').append('<span class="selectedTerm" id="'+$(this).prev().val()+'">'+$(this).text()+'<i></i></span>');
	 	}else if(len==1){
			if($(this).hasClass('active')){
	 			$(this).removeClass('active').prev().attr('checked',false).siblings('span').css('color','#333');
	 			var val=$(this).prev().val();
				$('.selectedTerm').each(function(){
	 				if($(this).attr('id')==val){
	 					$(this).remove();
					}
				})
	 		}
	 	}
		windowHeight();
	 })

	$('.selected,.pledgeItem,.selectedKeyword').on('click','i',function(){
		var val=$(this).parent().attr('id');
		$('.factor input').each(function(){
			if($(this).val()==val){
				$(this).attr('checked',false).next().removeClass('active');
			}
		})
		$('.single input').each(function(){
			if($(this).val()==val){
				$(this).attr('checked',false).next().removeClass('active');
				$(this).next().siblings('span').css('color','#333');
			}
		})
		$(this).parent().remove();
		windowHeight();
	})
	//
	// /!*排序规则*!/
	$('.order').on('click','span',function(){
		$(this).toggleClass('active');
		if($(this).hasClass('active')){
	 		$(this).siblings('span').removeClass('active').prev().attr('checked',false);
	 		$(this).prev().attr('checked','checked');
	 	}else{
	 		$(this).removeClass('active').prev().attr('checked',false);
	 	}
	 })*/
	
	/*公司详情页面导航栏*/
	$('.navList').on('click','a',function(){
		$(this).addClass('active').parent().siblings().find('a').removeClass('active');
		$(this).prev().css('display','inline-block').parent().siblings().find('img').css('display','none');

    });
	/*$('.systemNavList').on('click','a',function(){
		$(this).addClass('active').parent().siblings().find('a').removeClass('active');
		$(this).prev().css('display','inline-block').parent().siblings().find('img').css('display','none');
	})*/
	
	/*滑过关注显示一个提示框*/
	$('.viewTable').on('mouseenter','.viewBox i',function(){
		$(this).next().css('display','block');
	}).on('mouseleave','i',function(){
		$(this).next().css('display','none');
	});
	/*$('.viewTable').on('click','.viewBox i',function(){
		$(this).toggleClass('current');
	});*/
	
	/*开始导入*/
	$('.exportStart').click(function(){
		$('.exportNote').css('display','block');
		$('.exportNote').siblings().css('display','none');
	});

	
	//融资服务管理
	//贷款渠道概况时间选择
	$('.loanTime').on('click','li',function(){
		$(this).addClass('active').find('i').css('display','block');
		$(this).siblings().removeClass('active').find('i').css('display','none');
	});
	
	/*贷款处理处理状态切换*/
	$('.handleResult').on('click','a',function(){
		$(this).addClass('active').parent().siblings().find('a').removeClass('active');
		$('.result').eq($(this).parent().index()).css('display','block').siblings('.result').css('display','none');
	});
	
	//增加抵押物类型
	// $('.addPledgebtn').click(function(){
	// 	$('.items').append('<span class="selectedTerm">'+$(this).prev().val()+'<i></i></span>');
	// 	$(this).prev().val('');
	//
	// });
	/*选择系统使用日期*/
	$('.lasteTime li').click(function(){
		$(this).addClass('liActive').siblings('li').removeClass('liActive');
	});
	/*删除服务优势*/
	$('.addPledge').on('click','.loanDelete',function(){
		$(this).parent().remove();
        windowHeight();
	});
	/*增加服务优势*/
    // $('.addPledge').on('click','.configBtn',function(){
    //     $(this).parent().prev().append('<li><span class="pledgeTxt">'+$(this).prev().val()+'</span><a class="loanDelete">删除</a></li>');
    //     $(this).prev().val('');
    //     windowHeight();
    // });
	//增加关键词
	$('.addKey').click(function(){
		$('.selectedKeyword').append('<span class="selectedTerm">'+$(this).parent().prev().find('select').val()+'<i></i></span>');
	});
	
	//客户配置
	//深度分析报告
	$('.numberBtn').click(function(){
		$(this).css('display','none').next().css('display','inline-block');
		$('.editNumber').val($('.number').text()).css('display','inline-block');
		$('.number').css('display','none');
	})
	// $('.serveBtn').click(function(){
	// 	$(this).css('display','none').prev().css('display','inline-block');
	// 	$('.number').text($('.editNumber').val()).css('display','inline-block');
	// 	$('.editNumber').css('display','none');
	// })

	//角色添加向上向下箭头切换
	$('.arrow').on('click','i',function(){
		$(this).css('display','none').siblings().css('display','block');
		//console.log($(this).index());
		if($(this).index()==0){
			$(this).parent().parent().height(40);
		}else{
            $(this).parent().parent().css('height','');
		}
	})
});

function serveBtnChange() {
	$('.serveBtn').css('display','none').prev().css('display','inline-block');
	$('.number').text($('.editNumber').val()).css('display','inline-block');
	$('.editNumber').css('display','none');
}

//判断有几个条件被选中
function checkLength(eleArr){
    var len = 0;
    eleArr.each(function(index,ele){
        if($(ele).attr('checked')){
            len++;
        }
    });
    return len;
}

//下载文件
function downloadFile(url){
    var iframe = document.getElementById("myIframe");
    if(iframe){
        iframe.src = url;
    }else{
        iframe = document.createElement("iframe");
        iframe.style.display = "none";
        iframe.src = url;
        iframe.id = "myIframe";
        document.body.appendChild(iframe);
    }
}
/*判断可是窗口的高度 */
function windowHeight() {
    $('.left').height($('.right').height());
    var height=$(window).height();
    var headerHeight = $("header").height();
    var footerHeight = $("footer").height();
    var mainHeight = $("main").outerHeight(true);
    var allHeight=headerHeight + footerHeight + mainHeight;
    //console.log(height+'  '+allHeight+'  '+mainHeight);
    if(height >= allHeight){
        $('body').height(height);
        $('footer').css('bottom','0');
    }else{
        $('body').height(allHeight);
        $('footer').css('bottom','auto');
    }
}
//判断数组是否包含某个元素
Array.prototype.contain = function(val)
{
    for (var i = 0; i < this.length; i++)
    {
        if (this[i] == val)
        {
            return true;
        }
    }
    return false;
};
