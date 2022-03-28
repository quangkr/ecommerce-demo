async function fetchHelper(url, { method, body }) {
    const res = await fetch(url, {
        method,
        body,
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            [APP_CONSTANTS.csrfHeader]: APP_CONSTANTS.csrfToken,
        },
    });

    if (res.redirected) {
        window.location.replace(res.url);
        return;
    }

    return res;
}

function isNum(n) {
    return !isNaN(n) && !isNaN(parseFloat(n));
}

function initializeToasts() {
    const toastNodeList = document.querySelectorAll('.toast');
    Array.prototype.forEach.call(toastNodeList, function (e) {
        new bootstrap.Toast(e);
    });
}
