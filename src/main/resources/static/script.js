 window.onload = function() { 
 var activeClass=sessionStorage.getItem('classValue');
let element =  document.getElementById(activeClass);
console.log(element);
element.classList.add("active");
 }
 
 function changeColor(evt, colorname) {
  sessionStorage.setItem('classValue',colorname);
  evt.currentTarget.className += " active";
}


function logOut(){
const confirm = window.confirm("are you sure?");
    if(confirm){
        sessionStorage.setItem('classValue','home');
	window.location='/students/logout';
    }
	}
	
	
	 
	function goBack() {
   window.history.back();
   }
   
   function changecolor(){
   
   }
   
 
   
  