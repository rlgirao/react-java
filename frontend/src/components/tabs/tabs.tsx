import React, { useState } from 'react';

interface TabsProps {
  children: React.ReactNode;
}

const Tabs: React.FC<TabsProps> = ({ children }) => {
  const [activeTab, setActiveTab] = useState(0);

  return (
    <div className="flex justify-center">
      <div className="w-full max-w-2xl">
        <div className="flex border-b border-gray-200">
          {React.Children.map(children, (child, index) => (
            <button
              key={index}
              className={`p-4 ${activeTab === index ? 'border-b-2 border-blue-500' : ''}`}
              onClick={() => setActiveTab(index)}
            >
              {(child as React.ReactElement<{ title: string }>).props.title}
            </button>
          ))}
        </div>
        <div className="p-4">
          {React.Children.map(children, (child, index) => (
            <div key={index} className={`${activeTab === index ? 'block' : 'hidden'}`}>
              {child}
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Tabs;