/**
 * 
 */
 
 console.log("js file integrated");
 //document.querySelector('.progressbarLayout').style.display = 'hide'
 document.querySelector('.progressbarLayout').style.visibility = 'hidden';
 

function showResult(organizationId,instituteId, classId,divisionId,instituteName, className, divisionName) {
  var loader = document.getElementById('loader');
  var mainLayout = document.getElementById('mainLayout');
  
  //document.querySelector('.progressbarLayout').style.display = 'show';
  document.querySelector('.progressbarLayout').style.visibility = 'visible';
  
  document.querySelector('.myLayout').style.display = 'none';

  console.log('working');
  
  
  let context="";
  let url = context.concat("http://localhost:8080/api/web/exam/regular/divisions/result?organizationId=",organizationId,"&instituteId=",instituteId,"&classId=",classId,"&divisionId=",divisionId,"&instituteName=",instituteName,"&className=",className,"&divisionName=",divisionName );
  
  
  //let url = context.concat("http://revoeducation.in:8080/api-4.0.7/web/exam/regular/divisions/result?organizationId=",organizationId,"&instituteId=",instituteId,"&classId=",classId,"&divisionId=",divisionId,"&instituteName=",instituteName,"&className=",className,"&divisionName=",divisionName );
   
  console.log(url)
  window.location.href = url;
}