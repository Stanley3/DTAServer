<html>
<body>
<h2>Hello World!</h2>
<script type="text/javascript">
	xhr = new XMLHttpRequest();
	xhr.open("get", "rest/sysUser/2", false);
	xhr.send(null);
	alert(xhr.responseText);
</script>
</body>
</html>
