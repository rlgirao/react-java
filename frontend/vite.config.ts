import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'

// https://vite.dev/config/
export default defineConfig(async () => {
  const tsconfigPaths = await import('vite-tsconfig-paths').then((mod) => mod.default);
  
  return {
    plugins: [
      react({
        babel: {
          plugins: [
            ["@babel/plugin-proposal-decorators", { "legacy": true }],
            ["@babel/plugin-proposal-class-properties", { "loose": true }]
          ]
        }
      }),
      tailwindcss(),
      tsconfigPaths()
    ],
  }
});
