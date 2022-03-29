import { CSRF_HEADER, CSRF_TOKEN } from './constants.js';

export async function fetchHelper(url, { method, body }) {
    const res = await fetch(url, {
        method,
        body,
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            [CSRF_HEADER]: CSRF_TOKEN,
        },
    });

    if (res.redirected) {
        window.location.replace(res.url);
        return;
    }

    return res;
}

export function isNum(n) {
    return !isNaN(n) && !isNaN(parseFloat(n));
}
