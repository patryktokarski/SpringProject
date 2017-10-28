<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${success != null}">
    <div class="callout callout-success">
        <h4>Success</h4>
            ${success}
    </div>
</c:if>
<c:if test="${info != null}">
    <div class="callout callout-info">
        <h4>Info</h4>
            ${info}
    </div>
</c:if>
<c:if test="${warning != null}">
    <div class="callout callout-warning">
        <h4>Warning</h4>
            ${warning}
    </div>
</c:if>
<c:if test="${error != null}">
    <div class="callout callout-danger">
        <h4>Error</h4>
            ${error}
    </div>
</c:if>