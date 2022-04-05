import { CSRF_HEADER, CSRF_TOKEN } from './constants.js';

export function fetchHelper(url, { method, body }) {
    return fetch(url, {
        method,
        body,
        headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            [CSRF_HEADER]: CSRF_TOKEN,
        },
    });
}

export function isNum(n) {
    return !isNaN(n) && !isNaN(parseFloat(n));
}
