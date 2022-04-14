function newMember() {
    const result = document.createElement('div');
    result.className = 'input-group mb-2';
    const input = document.createElement('input');
    input.className = 'form-control';
    input.setAttribute('placeholder', 'Product description');
    const addBtn = document.createElement('button');
    addBtn.className = 'btn btn-sm btn-outline-primary btn-add-description';
    addBtn.setAttribute('type', 'button');
    const addIcon = document.createElement('i');
    addIcon.className = 'bi bi-plus';
    const removeBtn = document.createElement('button');
    removeBtn.className = 'btn btn-sm btn-outline-danger btn-remove-description';
    removeBtn.setAttribute('type', 'button');
    const removeIcon = document.createElement('i');
    removeIcon.className = 'bi bi-x';

    addBtn.addEventListener('click', handleAdd);
    removeBtn.addEventListener('click', handleRemove);

    addBtn.append(addIcon);
    removeBtn.append(removeIcon);
    result.append(input);
    result.append(addBtn);
    result.append(removeBtn);

    return result;
}

function handleAdd(e) {
    const parent = e.currentTarget.parentNode;
    parent.insertAdjacentElement('afterend', newMember())
    renumbering();
}

function handleRemove(e) {
    const parent = e.currentTarget.parentNode;
    const groupRoot = parent.parentNode;
    if (groupRoot.childElementCount > 1) {
        parent.remove();
    } else {
        parent.querySelector('input').value = '';
    }
    renumbering();
}

function renumbering() {
    const inputGroups = document.getElementById('form-description-group').children;
    for (var i = 0; i < inputGroups.length; i++) {
        const input = inputGroups[i].querySelector('input');
        input.setAttribute('name', `description[${i}]`);
        input.setAttribute('id', `description${i}`);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const groupRoot = document.getElementById('form-description-group');
    if (groupRoot.childElementCount < 1) {
        groupRoot.append(newMember());
        renumbering();
    }

    Array.prototype.forEach.call(document.querySelectorAll('.btn-add-description'), function (btn) {
        btn.addEventListener('click', handleAdd);
    });
    Array.prototype.forEach.call(document.querySelectorAll('.btn-remove-description'), function (btn) {
        btn.addEventListener('click', handleRemove);
    });
});
