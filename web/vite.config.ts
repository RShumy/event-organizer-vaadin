import { UserConfigFn } from 'vite';
import { overrideVaadinConfig } from './vite.generated';

const customConfig: UserConfigFn = (env) => ({
  build: {
    target: "es2021"     // <-- Fix BigInt errors
  }
});

export default overrideVaadinConfig(customConfig);
