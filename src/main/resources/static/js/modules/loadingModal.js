const modalElement = document.getElementById('loading-modal');

export const loadingModal = bootstrap.Modal.getOrCreateInstance(modalElement);
export async function asyncShow() {
    const promise = new Promise((resolve) => {
        function shown() {
            resolve();
        }
        modalElement.addEventListener('shown.bs.modal', shown, { once: true });
    });
    loadingModal.show();
    return promise;
}
export async function asyncHide() {
    const promise = new Promise((resolve) => {
        function hidden() {
            resolve();
        }
        modalElement.addEventListener('hidden.bs.modal', hidden, { once: true });
    });
    loadingModal.hide();
    return promise;
}

export default loadingModal;
