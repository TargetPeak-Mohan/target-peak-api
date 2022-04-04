/**
 * 
 */
 
 console.log("js file integrated");
 //document.querySelector('.progressbarLayout').style.display = 'hide'
 document.querySelector('.progressbarLayout').style.visibility = 'hidden';
 

function showPeakResult(organizationId,instituteId, classId,divisionId,subjectId, userId, studentId,questionPaperId,roleId) {
  var loader = document.getElementById('loader');
  var mainLayout = document.getElementById('mainLayout');
  
  //document.querySelector('.progressbarLayout').style.display = 'show';
  document.querySelector('.progressbarLayout').style.visibility = 'visible';
  
  document.querySelector('.myLayout').style.display = 'none';

  console.log('working');
  
  let context="";
  
  
  let url = context.concat("http://localhost:8080/api/web/exam/peak/students?action=1&organizationId=",organizationId,"&instituteId=",instituteId,"&classId=",classId,"&divisionId=",divisionId,"&subjectId=",subjectId,"&userId=",userId,"&studentId=",studentId,"&questionPaperId=",questionPaperId,"&roleId=",roleId );
  
  //let url = context.concat("http://revoeducation.in:8080/api-4.0.7/web/exam/peak/students?action=1&organizationId=",organizationId,"&instituteId=",instituteId,"&classId=",classId,"&divisionId=",divisionId,"&subjectId=",subjectId,"&userId=",userId,"&studentId=",studentId,"&questionPaperId=",questionPaperId,"&roleId=",roleId );
  	   
  console.log(url)
  window.location.href = url;
}