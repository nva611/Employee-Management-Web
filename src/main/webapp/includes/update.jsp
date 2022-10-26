<form action="update" method="post">
                 
                <fieldset class="form-group">
                    <label>Id</label> 
                    <input type="text" name="id" class="form-control" value="<%= employee.getId() %>" readonly/>
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Name</label> 
                    <input type="text" class="form-control" value="<%= employee.getName() %>"
                        name="name" required="required" >
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Sex</label> 
                    <div>
                    <% if(employee.getSex().equals("0")) { %>
                    <input type="radio" id="Female"
                         class=""  checked="checked"
                        name="sex" value="0" required="required" > 
                    <label for="Female">Female</label>
                    
                    <input type="radio" id="Male"
                         class="" 
                        name="sex" value="1" required="required" > 
                        <label for="Male">Male</label>
                    </div>
                    <% } %>
                    <% if(employee.getSex().equals("1")) { %>
                    <input type="radio" id="Female"
                         class="" value="0" 
                        name="sex" required="required" > 
                    <label for="Female">Female</label>
                    
                    <input type="radio" id="Male"
                         class="" value="1" checked="checked"
                        name="sex" required="required" >
                        <label for="Male">Male</label>
                    </div>
                    <% } %>
                </fieldset> 
                
                <fieldset class="form-group">
                    <label>Birth Date</label> 
                    <div display="flex" style="border:1px" class="form-group" >     
                        <label>Date</label>               
                        <input type="text" style="width:80px" class="" value="<%= date.getDate() %>"
                            name="date" required="required">
                            
                        <label>Month</label>
                        <input type="text" style="width:80px" class="" value="<%= date.getMonth() + 1 %>"
                            name="month" required="required">
                            
                        <label>Year</label>
                        <input type="text" style="width:80px" class="" value="<%= date.getYear() + 1900 %>"
                            name="year" required="required">
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <label>Home Town</label> <input type="text"
                       class="form-control" value="<%= employee.getHomeTown() %>"
                        name="homeTown">
                </fieldset>

                <fieldset class="form-group">
                    <label>Phone</label> <input type="text"
                        class="form-control" value="<%= employee.getPhone() %>"
                        name="phone">
                </fieldset>

                <fieldset class="form-group">
                    <label>Address</label> <input type="text"
                        class="form-control" value="<%= employee.getAddress() %>"
                        name="address">
                </fieldset>

                <fieldset class="form-group">
                     <label>Status</label> <br>
                    <%if(employee.getStatus().equals("1")) { %>
                    <input type="radio" id="Active" value="1" class="" name="status" checked= "checked" >
                        <label for="Active">Active</label>
                        
                    <input type="radio" id="TemporarilyLocked" value="2" class="" name="status">
                        <label for="TemporarilyLocked">Temporarily locked</label>
                        
                    <input type="radio" id="LockedForever" value="3" class="" name="status">
                        <label for="LockedForever">Locked forever</label>
                     <% } %>
                     <%if(employee.getStatus().equals("2")) { %>
                     <input type="radio" id="Active" value="1" class="" name="status"  >
                        <label for="Active">Active</label>
                        
                    <input type="radio" id="TemporarilyLocked" value="2" class="" name="status" checked= "checked">
                        <label for="TemporarilyLocked">Temporarily locked</label>
                        
                    <input type="radio" id="LockedForever" value="3" class="" name="status">
                        <label for="LockedForever">Locked forever</label>
                        <% } %>
                        <%if(employee.getStatus().equals("3")) { %>
                     <input type="radio" id="Active" value="1" class="" name="status" >
                        <label for="Active">Active</label>
                        
                    <input type="radio" id="TemporarilyLocked" value="2" class="" name="status">
                        <label for="TemporarilyLocked">Temporarily locked</label>
                        
                    <input type="radio" id="LockedForever" value="3" class="" name="status" checked= "checked">
                        <label for="LockedForever">Locked forever</label>
                        <% } %>
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
            
            
            </form> 