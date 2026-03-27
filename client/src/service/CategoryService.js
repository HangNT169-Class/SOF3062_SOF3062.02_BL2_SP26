// logic cua phia FE
// duong dan chung
const API = 'http://localhost:8080/api/category-management'

// API => xu ly dong bo bat
// asyc.. await
// GET => hien thi
export const getListCate = async () => {
  const res = await fetch(API)
  // neu BE co return thi FE moi co return
  // Neu BE co tham so truyen vao => FE moi co
  return res.json()
}

// GET => detail
export const detailCate = async (id) => {
  // gia tri bien can truyen vao duong dan => ${ten bien}
  const res = await fetch(`${API}/detail/${id}`)
  // neu BE co return thi FE moi co return
  // Neu BE co tham so truyen vao => FE moi co
  return res.json()
}

// DELETE => remove
export const deleteCate = async (id) => {
  // gia tri bien can truyen vao duong dan => ${ten bien}
  await fetch(`${API}/delete?id1=${id}`, {
    method: 'DELETE',
  })
}

// ADD
export const addCate = async (data) => {
  // gia tri bien can truyen vao duong dan => ${ten bien}
  await fetch(`${API}/add`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
}

export const updateCate = async (data, id) => {
  // gia tri bien can truyen vao duong dan => ${ten bien}
  await fetch(`${API}/update/${id}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
}
