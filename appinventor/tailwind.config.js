/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./appengine/src/**/*.java",
    "./appengine/src/**/*.xml",
    "./appengine/src/**/*.html",
    "./appengine/war/**/*.html",
    "./appengine/war/**/*.xml",
    "./blocklyeditor/**/*.js",
    "./blocklyeditor/**/*.html",
  ],
  theme: {
    extend: {
      colors: {
        // App Inventor brand colors
        'ai-green': {
          50: '#f0f9e8',
          100: '#dcf2c8',
          200: '#c5e8a3',
          300: '#a9dc75',
          400: '#8fc202',
          500: '#7ba301',
          600: '#658801',
          700: '#4f6b01',
          800: '#3c5001',
          900: '#2c3a01',
        },
        'ai-gray': {
          50: '#f8f9fa',
          100: '#f1f3f4',
          200: '#e8eaed',
          300: '#dadce0',
          400: '#bdc1c6',
          500: '#9aa0a6',
          600: '#80868b',
          700: '#5f6368',
          800: '#3c4043',
          900: '#202124',
        }
      },
      fontFamily: {
        'poppins': ['Poppins', 'Helvetica', 'Arial', 'sans-serif'],
        'inter': ['Inter', 'Roboto', 'sans-serif'],
      },
      spacing: {
        '18': '4.5rem',
        '88': '22rem',
      },
      borderRadius: {
        'xl': '0.75rem',
        '2xl': '1rem',
      },
      boxShadow: {
        'ai': '0 2px 8px rgba(0, 0, 0, 0.1)',
        'ai-lg': '0 4px 16px rgba(0, 0, 0, 0.15)',
      },
      animation: {
        'fade-in': 'fadeIn 0.3s ease-in-out',
        'slide-up': 'slideUp 0.3s ease-out',
      },
      keyframes: {
        fadeIn: {
          '0%': { opacity: '0' },
          '100%': { opacity: '1' },
        },
        slideUp: {
          '0%': { transform: 'translateY(10px)', opacity: '0' },
          '100%': { transform: 'translateY(0)', opacity: '1' },
        },
      },
    },
  },
  plugins: [
    // Custom plugin for App Inventor components
    function({ addUtilities, theme }) {
      const newUtilities = {
        '.ode-focus-ring': {
          '@apply focus:outline-none focus:ring-2 focus:ring-ai-green-400 focus:ring-offset-2': {},
        },
        '.ode-card': {
          '@apply bg-white rounded-lg border border-gray-200 p-4 shadow-ai': {},
        },
        '.ode-list-item': {
          '@apply px-4 py-2 hover:bg-gray-50 transition-colors duration-150': {},
        },
      };
      addUtilities(newUtilities);
    },
  ],
  // Important: Preserve existing CSS
  important: false,
  corePlugins: {
    // Disable preflight to avoid conflicts with existing styles
    preflight: false,
  },
}