const primaryToastElement = document.getElementById('toast-primary');
const successToastElement = document.getElementById('toast-success');
const dangerToastElement = document.getElementById('toast-danger');

function getElement(type) {
    switch (type) {
        case 'primary':
            return primaryToastElement;
            break;
        case 'success':
            return successToastElement;
            break;
        case 'danger':
            return dangerToastElement;
            break;
    }
}
function getContentElement(type) {
    return getElement(type).querySelector('.toast-body');
}
function getInstance(type) {
    return bootstrap.Toast.getOrCreateInstance(getElement(type));
}

export function showToast(message, type = 'primary') {
    getContentElement(type).textContent = message;
    getInstance(type).show();
}
export function hideToast(type = 'primary') {
    getInstance(type).hide();
}
export async function asyncShow(message, type = 'primary') {
    const promise = new Promise((resolve) => {
        function shown() {
            resolve();
        }
        getInstance(type).addEventListener('shown.bs.toast', shown, { once: true });
    });
    showToast(message, type);
    return promise;
}
export async function asyncHide(type = 'primary') {
    const promise = new Promise((resolve) => {
        function hidden() {
            resolve();
        }
        getInstance(type).addEventListener('hidden.bs.toast', hidden, { once: true });
    });
    hideToast(type);
    return promise;
}
