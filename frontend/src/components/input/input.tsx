import React from 'react';

interface InputProps {
  type: string;
  id: string;
  label?: string;
  value: string;
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  className?: string;
  error?: string;
}

const Input: React.FC<InputProps> = ({ type, id, label, value, onChange, className, error }) => {
  return (
    <div className="flex flex-col gap-0.5 w-full">
      {label && <label htmlFor={id} className="block text-sm font-medium text-gray-700">{label}</label>}
      <input
        type={type}
        id={id}
        value={value}
        onChange={onChange}
        className={`mt-1 block w-full px-3 py-2 border ${error ? 'border-red-500' : 'border-gray-300'} rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm ${className}`}
      />
      {error && <span className="text-red-500 text-sm">{error}</span>}
    </div>
  );
};

export default Input;