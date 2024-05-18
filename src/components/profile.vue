<template>
  <div class="content">
    <div class="profile-container">
      <h2>{{ user.name }}</h2>
      <p>{{ user.email }}</p>
      <p>{{ user.bio }}</p>
      <button @click="editProfile">Edit Profile</button>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from "vue";
import { useRouter } from 'vue-router';

const user = reactive({
  name: "John Doe",
  email: "john.doe@example.com",
  bio: "Hello, I'm John Doe. I love programming and coffee."
});

function editProfile() {
  const newName = prompt("Enter new name", user.name);
  if (newName && newName !== user.name) {
    user.name = newName;
  }

  const newEmail = prompt("Enter new email", user.email);
  if (newEmail && newEmail !== user.email) {
    user.email = newEmail;
  }

  const newBio = prompt("Enter new bio", user.bio);
  if (newBio && newBio !== user.bio) {
    user.bio = newBio;
  }
}
</script>

<style scoped>
.content {
  padding: 20px;
}

.profile-container {
  border: 1px solid #ccc;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 5px;
}
</style>