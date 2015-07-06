<script type="text/javascript">
<!--

//-->
	alert(1);
</script>
<% response.sendRedirect(response.encodeRedirectURL(request.getContextPath() +
        "/index.html")); %>
<%=request.getContextPath() + "/index.html"%>