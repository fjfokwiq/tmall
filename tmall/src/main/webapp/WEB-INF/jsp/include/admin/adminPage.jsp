<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    $(function(){
        $("ul.pagination li.disabled a").click(function(){
            return false;
        });
    });

</script>


<nav>
    <ul class="pagination pagination-lg">
        <li>
            <a  href="?offset=0" aria-label="Previous" >
                <span aria-hidden="true">«</span>
            </a>
        </li>

        <li >
            <a  href="?offset=${page.offset-page.count}" aria-label="Previous" >
                <span aria-hidden="true">‹</span>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
            <li>
                <a href="?offset=${status.index*page.count}">${status.count}</a>
            </li>

        </c:forEach>

        <li >
            <a href="?offset=${page.offset+page.count}" aria-label="Next">
                <span aria-hidden="true">›</span>
            </a>
        </li>
        <li >
            <a href="?offset=${page.last}" aria-label="Next">
                <span aria-hidden="true">»</span>
            </a>
        </li>
    </ul>
</nav>
