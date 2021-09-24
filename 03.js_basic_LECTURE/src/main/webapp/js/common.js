/**
 * filename: js/common.js
 */
//alert("js 외부파일 로딩 : js/common.js");
//console.log('>>> js 외부파일 로딩 : js/common.js');

/* 현재날짜 기본형식(년도4자리-월2자리-일2자리) 반환 함수 
	-- 월 : 1 ~ 9 => 01.. 09
	-- 일 : 1 ~ 9 => 01.. 09
*/
function getCurrentDate() {
	var todate = new Date();
	var year = todate.getFullYear();

	//var month = todate.getMonth() + 1;	// 9, 10, 11
	//var date = todate.getDate();
	
	//var month = ('0' + todate.getMonth() + 1).slice(-2); // 09, 010, 011
	//var date = ('0' + todate.getDate()).slice(-2);
	
	var month = todate.getMonth() + 1;
	month = month < 10 ? '0' + month: month;	
	
	var date = todate.getDate();
	date = date < 10 ? '0' + date: date;
	
	console.log("현재날짜: ", year + "-" + month + "-" + date);
	// 현재날짜:  2021-9-17 => 2021-09-17
	
	return year + "-" + month + "-" + date;
}
 
 