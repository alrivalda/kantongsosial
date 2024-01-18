/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}",  "./node_modules/flowbite/**/*.js"],
  theme: {
    colors : {
      biru : '#1976D2',
    },
    extend: {},
  },
  plugins: [require('flowbite/plugin')],
}

