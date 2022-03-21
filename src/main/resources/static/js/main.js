async function fetchHelper(url, { method, body }) {
    const res = await fetch(url, {
        method,
        body,
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            [APP_CONSTANTS.csrfHeader]: APP_CONSTANTS.csrfToken,
        }
    });

    if (res.redirect) {
        window.location.replace(res.url);
        return;
    }

    return res;
}
