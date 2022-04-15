import { CONTEXT_ROOT } from './modules/constants.js';
import { fetchHelper } from './modules/utils.js';

const ADMIN_PRODUCT_LIST_CONST = {};

async function handleRemove() {
    const checkedIds = getCheckedBoxes().map(cb => cb.getAttribute('data-product-id'));

    const res = await fetchHelper(`${CONTEXT_ROOT}/admin/products/`, {
        method: 'DELETE',
        body: JSON.stringify(checkedIds),
    });

    if (res && res.ok) {
        uncheckAll();
    }
    window.location.reload();
}

async function handleRestore() {
    const checkedIds = getCheckedBoxes().map(cb => cb.getAttribute('data-product-id'));

    const res = await fetchHelper(`${CONTEXT_ROOT}/admin/products/`, {
        method: 'PUT',
        body: JSON.stringify(checkedIds),
    });

    if (res && res.ok) {
        uncheckAll();
    }
    window.location.reload();
}

function checkboxHandler (e) {
    let targetButton;
    if (ADMIN_PRODUCT_LIST_CONST.removeButton) {
        targetButton = ADMIN_PRODUCT_LIST_CONST.removeButton;
    } else if (ADMIN_PRODUCT_LIST_CONST.restoreButton) {
        targetButton = ADMIN_PRODUCT_LIST_CONST.restoreButton;
    }

    if (e.target.checked) {
        targetButton.toggleAttribute('disabled', false);
    } else if (getCheckedBoxes().length > 0) {
        targetButton.toggleAttribute('disabled', true);
    }
}

function getCheckedBoxes() {
    return Array.from(ADMIN_PRODUCT_LIST_CONST.checkboxElements).filter(e => e.checked);
}

function uncheckAll() {
    getCheckedBoxes().forEach(cb => { cb.checked = false });
}

document.addEventListener('DOMContentLoaded', () => {
    ADMIN_PRODUCT_LIST_CONST.checkboxElements = document.querySelectorAll('.admin-product-remove-item input[type="checkbox"]');
    ADMIN_PRODUCT_LIST_CONST.removeButton = document.querySelector('button.btn-product-remove');
    ADMIN_PRODUCT_LIST_CONST.restoreButton = document.querySelector('button.btn-product-restore');

    Array.prototype.forEach.call(ADMIN_PRODUCT_LIST_CONST.checkboxElements, function (checkbox) {
        checkbox.addEventListener('click', checkboxHandler);
    });
    if (ADMIN_PRODUCT_LIST_CONST.removeButton) {
        ADMIN_PRODUCT_LIST_CONST.removeButton.addEventListener('click', handleRemove);
    }
    if (ADMIN_PRODUCT_LIST_CONST.restoreButton) {
        ADMIN_PRODUCT_LIST_CONST.restoreButton.addEventListener('click', handleRestore);
    }
});
