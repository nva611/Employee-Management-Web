
<%   for(Employee e:listEmployee) { %>
<tr>
	<td><%= e.getId() %></td>
	<td><%= e.getName() %></td>
	<td><%= e.getSex() %></td>
	<td><%= e.getbDate() %></td>
	<td><%= e.getHomeTown() %></td>
	<td><%= e.getPhone() %></td>
	<td><%= e.getAddress() %></td>
	<td><%= e.getStatus() %></td>
	<td><a href="edit?id=<%= e.getId() %>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<%= e.getId()%>">Delete</a></td>
</tr>
<%}%>