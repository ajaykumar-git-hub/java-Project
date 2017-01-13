<%@ include file="template/header.jsp"%>
<h1>
	Add New Product
</h1>

<c:url var="addAction" value="/product/add" ></c:url>



<form:form action="${addAction}" modelAttribute="product" method="POST" enctype="multipart/form-data">



<table>
	<c:if test="${!empty product.productName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
			<form:errors path="name"></form:errors>
			
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
			<form:errors path="country" />
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="image">
				<spring:message text="Image"/>
			</form:label>
		</td>
		<td>
			<form:input type="file" path="image" />
			<form:errors path="image" />
		</td>
	</tr>
	
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty product.productName}">
				<input type="submit"
					value="<spring:message text="Edit Product"/>" />
			</c:if>
			<c:if test="${empty product.productName}">
				<input type="submit"
					value="<spring:message text="Add Product"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Product List</h3>
<c:if test="${!empty listProducts}">
	<table class="tg">
	<tr>
		<th width="80">Product ID</th>
		<th width="120">Product Name</th>
		<th width="120">Brand</th>
		<th width="120">Price</th>
		<th width="120">Category</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listProducts}" var="person">
		<tr>
			<td>${product.productID}</td>
			<td>$product.productName}</td>
			<td>${product.brand}</td>
			<td>${product.price}</td>
			<td>${product.category}</td>
			<td><a href="<c:url value='/edit/${product.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${product.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<%@ include file="template/footer.jsp"%>
