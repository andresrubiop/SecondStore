$(document).ready(function($){
    
    
    
//------Slide images------
   
   $(function() {
    var width = 1350;
    var animationSpeed = 1000;
    var pause = 6000;
    var currentSlide = 1;
    
    var $slider = $('#slider');
    var $slideContainer = $('.slides', $slider);
    var $slides = $('.slide', $slider);

    var interval;
       
       
       
         if(currentSlide==1){
            $('.anime_word').fadeIn(1000);
          }
                
       
       
    $('.right').click(function(){
         currentSlide++;
         $slideContainer.animate({'margin-left': '-='+width}, animationSpeed, function() {
             if(currentSlide==4){
                  $('.anime_word').fadeIn(1000);
               }
             
               if(currentSlide!=4){
                  $('.anime_word').fadeOut(200);
               }
             
             if(currentSlide==2){
                 $('.anime_word2').fadeIn(1000);
             }
             
             if(currentSlide!=2){
                 $('.anime_word2').fadeOut(200);
             }
             
             if(currentSlide==3){
                 $('.anime_word3').fadeIn(1000);
             }
             if(currentSlide!=3){
                 $('.anime_word3').fadeOut(200);
             }
             
              if (currentSlide === $slides.length) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
            });
        
    });
       
    $('.left').click(function(){

         if(currentSlide!=1){
                  $('.anime_word').fadeOut(200);
              
         currentSlide--;
         $slideContainer.animate({'margin-left': '+='+width}, animationSpeed, function() {
               if(currentSlide==1){
                  $('.anime_word').fadeIn(1000);
               }
              if(currentSlide==2){
                 $('.anime_word2').fadeIn(1000);
             }
             
              if(currentSlide==3){
                 $('.anime_word3').fadeIn(1000);
             }
               if(currentSlide!=2){
                 $('.anime_word2').fadeOut(200);
             }
             if(currentSlide!=3){
                 $('.anime_word3').fadeOut(200);
             }
            
                if (currentSlide<0) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
            });
         }
        
        
    });

    function startSlider() {
        interval = setInterval(function() {
             currentSlide++;
            $slideContainer.animate({'margin-left': '-='+width}, animationSpeed, function() {
                 
                if(currentSlide==4){
                  $('.anime_word').fadeIn(1000);
                   }      
             
                 if(currentSlide!=4){
                  $('.anime_word').fadeOut(200);
                   }
                
                if (currentSlide === $slides.length) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
                
                    if(currentSlide==2){
                 $('.anime_word2').fadeIn(1000);
                     }

                     if(currentSlide!=2){
                         $('.anime_word2').fadeOut(200);
                     }

                     if(currentSlide==3){
                         $('.anime_word3').fadeIn(1000);
                     }
                     if(currentSlide!=3){
                         $('.anime_word3').fadeOut(200);
                     }
            });
        }, pause);
    }
    function pauseSlider() {
        clearInterval(interval);
    }

    $slider
        .on('mouseenter', pauseSlider)
        .on('mouseleave', startSlider);

    startSlider();
});
    
    
    
    //------------------------------login--registration------
    $(function(){
        $('.login').click(function(){
            
            $('.registration_page').hide();
            $('.login_page').show();
            
        });
        
        $('.registration').click(function(){
            
             $('.registration_page').show();
            $('.login_page').hide();
            
        })
    })
    
    //---------------------scrool to div----------------------
    
    $(".shopnow").click(function() {
    $('html,body').animate({
        scrollTop: $(".middle").offset().top},
        'slow');
}   );
    
    
      $(".shopnow1").click(function() {
    $('html,body').animate({
        scrollTop: $(".middle").offset().top},
        'slow');
}   );
    
      $(".shopnow2").click(function() {
    $('html,body').animate({
        scrollTop: $(".logincontent").offset().top},
        'slow');
}   );
    
    $(".third").click(function(){
        $('html,body').animate({
           scrollTop: $(".about_content").offset().top},
            'slow'); 
        });
    
     $(".fourth").click(function(){
        $('html,body').animate({
           scrollTop: $(".about_content").offset().top},
            'slow'); 
        });
        
    
    //-------------------forgot password----------------
    
    $('.ctrl').click(function(){
        $('.forgotten_pass').toggle(500);
    })
    
    
    

});