function ohSnap(n,t){var o={color:null,icon:null,duration:"2000","container-id":"ohsnap","fade-duration":"fast"};t="object"==typeof t?$.extend(o,t):o;var a=$("#"+t["container-id"]),e="",i="",h="";t.icon&&(e="<span class='"+t.icon+"'></span> "),t.color&&(i="alert-"+t.color),h=$('<div class="alert '+i+'">'+e+n+"</div>").fadeIn(t["fade-duration"]),a.append(h),h.on("click",function(){ohSnapX($(this))}),setTimeout(function(){ohSnapX(h)},t.duration)}function ohSnapX(n,t){defaultOptions={duration:"fast"},t="object"==typeof t?$.extend(defaultOptions,t):defaultOptions,"undefined"!=typeof n?n.fadeOut(t.duration,function(){$(this).remove()}):$(".alert").fadeOut(t.duration,function(){$(this).remove()})}
