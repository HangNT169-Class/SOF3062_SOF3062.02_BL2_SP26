<!-- Page la so trang de dang co -->
<template>
  <h1>Quan ly category</h1>
  <FormCategoryComponent />
  <table>
    <thead>
      <tr>
        <th>STT</th>
        <th>Code</th>
        <th>Name</th>
      </tr>
    </thead>
  </table>
</template>

<script setup>
import FormCategoryComponent from '@/component/FormCategoryComponent.vue'
import { getListCate } from '@/service/CategoryService'
import { onMounted, ref } from 'vue'
const list = ref([])
const fetchData = async () => {
  list.value = await getListCate()
}
// gan list API vao dom => onMount
onMounted(fetchData)
</script>

<style lang="scss" scoped></style>
