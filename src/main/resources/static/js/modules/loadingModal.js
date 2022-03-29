const modalElement = document.getElementById('loading-modal');

export const loadingModal = bootstrap.Modal.getOrCreateInstance(modalElement);
export async function hasShown() {
    return new Promise((resolve) => {
        function shown() {
            resolve();
        }
        modalElement.addEventListener('shown.bs.modal', shown, { once: true });
    });
}
export async function hasHidden() {
    return new Promise((resolve) => {
        function hidden() {
            resolve();
        }
        modalElement.addEventListener('hidden.bs.modal', hidden, { once: true });
    });
}

export default loadingModal;
