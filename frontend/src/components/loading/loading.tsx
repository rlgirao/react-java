import React from 'react';

const Loading: React.FC = () => {
  return (
    <div className="fixed inset-0 flex items-center justify-center bg-gray-300 opacity-50 z-50">
      <div className="loader ease-linear rounded-full border-8 border-t-8 border-gray-500 h-25 w-25"></div>
    </div>
  );
};

export default Loading;