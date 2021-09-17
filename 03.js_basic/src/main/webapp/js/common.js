/**
 * filename: js/common.js
 */
//alert("js 외부파일 로딩 : js/common.js");
//console.log('>>> js 외부파일 로딩 : js/common.js');

/* 현재날짜 기본형식(YYYY-MM-DD) */
function getCurrentDate() {
	var todate = new Date();
	var year = todate.getFullYear();
	var month = todate.getMonth() + 1;
	var date = todate.getDate();
	// var date = ('0' + todate.getDate()).slice(-2);
	console.log( year + "-" +  month + "-" + date);
	if (month <= 9) {
		month = "0" + month;
	}
	
	if (date<= 9) {
		date= "0" + date;
	}
	
	// 3항 연산자
	// month = month <10 ? '0' + month : month;
	
	return year + "-" +  month + "-" + date;
	//return "2021-09-17";
}