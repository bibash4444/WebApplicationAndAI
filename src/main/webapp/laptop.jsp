
<%@page import="java.util.*"%>
<%@page import="Model.ProductModel"%>
<jsp:include page="components/header.jsp">
    <jsp:param name="pagetitle" value="COMPUTER FOR YOU | LAPTOP" />
</jsp:include>

<jsp:include page="components/navbar.jsp"/>

<% List<ProductModel> productModels = (List<ProductModel>) request.getAttribute("itemsdetails");%>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>List of laptops</h4>
                    
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="row">

            <div class="col-lg-9">
                <div class="shop__product__option">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="shop__product__option__left">
                                <p>Showing <%=productModels.size()%> results </p>
                            </div>
                        </div>

                    </div>
                </div> 
            </div>
        </div>
        <div class="row">
            <% for (ProductModel productModel : productModels) {%>
            <div class="col-lg-4">
                <div class="product__item">
                    <a href="shop-details.jsp">
                        <img class="product__item__pic set-bg" src="<%=productModel.getImage()%>"/>
                        <!--<div class="product__item__pic set-bg" data-setbg="img/shop-details/product-big-2.png"> </div>-->
                    </a>
                    <div class="product__item__text">
                        <h6>  <%=productModel.getProductname()%></h6>
                        <%if (session.getAttribute("loggedinuserid")!=null) {%>
                        <a href="#" class="primary-btn" style="color: white;">Add To Cart</a>
                        <%} else { %>
                        <a href="./login.jsp" class="primary-btn" style="color: white;">Login to continue</a>
                        <% } %>
                        <h5>&#163;<%=productModel.getPrice()%></h5>

                    </div>
                </div>
            </div>
            <%}%>

        </div>
    </div>
</section>
<!-- Shop Section End -->



<jsp:include page="components/footer.jsp"/>