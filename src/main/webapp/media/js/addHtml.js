function submit(form, url, contentType) {
	var flag = $('#' + form).validationEngine('validate');
	console.log($('#' + form).serialize());
	var dataArray = $('#' + form).serializeArray();
	var file = new Object();
	file.name = "photo";
	file.value = document.getElementsByName('photo')[0].value;
	dataArray[dataArray.length] = file;
	console.log(dataArray);
	if (flag) {
		$.ajax({
			url : url,
			type : 'post',
			dataType : 'json',
			contentType: contentType,
			/*data : $('#' + form).serialize(),*/
			data: dataArray,
			processData : false,
			success : function(data) {
				alert(data.desc);
			},
			error : function(xhr, err) {
				alert(err + " " + xhr.responseText);
			}
		});
	}
}